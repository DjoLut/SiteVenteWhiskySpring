package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;
import com.whisky.henallux.whisky.dataAccess.repository.OrderRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderDAO {
    private OrderRepository orderRepository;
    private SessionFactory sessionFactory;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, SessionFactory sessionFactory, ProviderConverter providerConverter)
    {
        this.orderRepository = orderRepository;
        this.sessionFactory = sessionFactory;
        this.providerConverter = providerConverter;
    }

    /*public void addOrder(Order order)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(providerConverter.orderToOrderEntity(order));
        session.getTransaction().commit();
    }

    public ArrayList<Order> getAllOrderByUtilisateur(String username)
    {
        List<OrderEntity> orderEntities = orderRepository.findAllByUtilisateurId(username);
        ArrayList<Order> orders = new ArrayList<>();
        for(OrderEntity entity : orderEntities)
        {
            Order order = providerConverter.orderEntityToOrder(entity);
            orders.add(order);
        }
        return orders;
    }*/

}
