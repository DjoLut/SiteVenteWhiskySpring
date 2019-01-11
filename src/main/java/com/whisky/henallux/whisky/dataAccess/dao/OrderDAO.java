package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;
import com.whisky.henallux.whisky.dataAccess.repository.OrderRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Order;
import com.whisky.henallux.whisky.service.Panier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;

@Service
@Transactional
public class OrderDAO {
    private OrderRepository orderRepository;
    private SessionFactory sessionFactory;
    private ProviderConverter providerConverter;
    private UserDAO userDAO;
    private CommandLineDAO commandLineDAO;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, UserDAO userDAO, CommandLineDAO commandLineDAO, SessionFactory sessionFactory, ProviderConverter providerConverter)
    {
        this.orderRepository = orderRepository;
        this.userDAO = userDAO;
        this.sessionFactory = sessionFactory;
        this.providerConverter = providerConverter;
        this.commandLineDAO = commandLineDAO;
    }

    public void saveOrder(Order order, Panier panier)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.orderToOrderEntity(order));
        session.getTransaction().commit();
        order.setId(((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue());
        commandLineDAO.addPanier(order, panier);
    }

    public void addPanier(Panier panier)
    {
        Order order = new Order();
        Date date = new Date();
        order.setDateOrder(date);
        order.setValidity(true);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        order.setUtilisateur(providerConverter.userModelToUserEntity(userDAO.getUserByUsername(authentication.getName())));

        order.setPromotion(panier.calculTotalPromo());
        order.setTotalPrice(panier.totalPriceWhisky());

        saveOrder(order, panier);
    }

    public Order getOrderByUtilisateur(String username)
    {
        OrderEntity orderEntity = orderRepository.findAllByUtilisateurUsername(username);
        return providerConverter.orderEntityToOrder(orderEntity);
    }

}
