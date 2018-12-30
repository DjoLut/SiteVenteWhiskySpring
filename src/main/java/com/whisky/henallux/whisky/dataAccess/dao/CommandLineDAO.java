package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.CommandLineEntity;
import com.whisky.henallux.whisky.dataAccess.repository.CommandLineRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.CommandLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommandLineDAO {
    private CommandLineRepository commandLineRepository;
    private SessionFactory sessionFactory;
    private ProviderConverter providerConverter;

    @Autowired
    public CommandLineDAO(CommandLineRepository commandLineRepository, SessionFactory sessionFactory, ProviderConverter providerConverter)
    {
        this.commandLineRepository = commandLineRepository;
        this.sessionFactory = sessionFactory;
        this.providerConverter = providerConverter;
    }

    public void addCommandLine(CommandLine commandLine)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(providerConverter.commandLineToCommandLineEntity(commandLine));
        session.getTransaction().commit();
    }

    public ArrayList<CommandLine> getAllCommandLine()
    {
        List<CommandLineEntity> commandLineEntities = commandLineRepository.findAll();
        ArrayList<CommandLine> commandLines = new ArrayList<>();
        for(CommandLineEntity entity : commandLineEntities)
        {
            CommandLine commandLine = providerConverter.commandLineEntityToCommandLine(entity);
            commandLines.add(commandLine);
        }
        return commandLines;
    }


}
