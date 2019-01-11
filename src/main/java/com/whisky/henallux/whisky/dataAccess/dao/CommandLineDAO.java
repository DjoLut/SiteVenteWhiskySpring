package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.CommandLineEntity;
import com.whisky.henallux.whisky.dataAccess.repository.CommandLineRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.CommandLine;
import com.whisky.henallux.whisky.model.Order;
import com.whisky.henallux.whisky.model.Whisky;
import com.whisky.henallux.whisky.service.Panier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CommandLineDAO {
    private CommandLineRepository commandLineRepository;
    private SessionFactory sessionFactory;
    private ProviderConverter providerConverter;
    private WhiskyDAO whiskyDAO;

    @Autowired
    public CommandLineDAO(CommandLineRepository commandLineRepository, SessionFactory sessionFactory, ProviderConverter providerConverter, WhiskyDAO whiskyDAO)
    {
        this.commandLineRepository = commandLineRepository;
        this.sessionFactory = sessionFactory;
        this.providerConverter = providerConverter;
        this.whiskyDAO = whiskyDAO;
    }

    public void saveCommandLine(CommandLine commandLine)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.commandLineToCommandLineEntity(commandLine));
        session.getTransaction().commit();
    }

    public void addPanier(Order order, Panier panier)
    {
        Map<Whisky, Integer> whiskys = panier.getWhiskys();

        for(Map.Entry<Whisky, Integer> entry : whiskys.entrySet()) {
            CommandLine commandLine = new CommandLine();

            commandLine.setRealPrice(entry.getKey().getPrice());
            commandLine.setQuantity(entry.getValue());
            commandLine.setWhiskyOrder(providerConverter.orderToOrderEntity(order));
            commandLine.setWhisky(providerConverter.whiskyToWhiskyEntity(entry.getKey()));

            whiskyDAO.updateStockQuantity(entry.getKey().getId(), entry.getKey().getStockQuantity()-entry.getValue());
            saveCommandLine(commandLine);
        }

    }


}
