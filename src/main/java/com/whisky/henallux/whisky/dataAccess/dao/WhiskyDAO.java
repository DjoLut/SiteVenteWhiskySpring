package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Whisky;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WhiskyDAO {
    private WhiskyRepository whiskyRepository;
    private ProviderConverter providerConverter;
    private SessionFactory sessionFactory;

    @Autowired
    public WhiskyDAO(WhiskyRepository whiskyRepository, ProviderConverter providerConverter, SessionFactory sessionFactory){
        this.whiskyRepository = whiskyRepository;
        this.providerConverter = providerConverter;
        this.sessionFactory = sessionFactory;
    }

    public ArrayList<String> getWhiskyName(){
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findAll();
        ArrayList<String> list = new ArrayList<>();
        for(WhiskyEntity whiskyEntity : whiskyEntities)
            list.add(whiskyEntity.getWhiskyName());
        return list;
    }

    //METHODE POUR AVOIR TOUS LES WHISKY
    public ArrayList<Whisky> getAllWhisky()
    {
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findAll();
        return whiskiesModelAsList(whiskyEntities);
    }

    //METHODE POUR AVOIR TOUS LES SINGLE MALT
    public ArrayList<Whisky> getWhiskyByCategorie(String categorie)
    {
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findByCategorieNom(categorie);
        return whiskiesModelAsList(whiskyEntities);
    }

    private ArrayList<Whisky> whiskiesModelAsList(List<WhiskyEntity> whiskyEntities){
        ArrayList<Whisky> whiskys = new ArrayList<>();
        for(WhiskyEntity entity : whiskyEntities)
        {
            Whisky whisky = providerConverter.whiskyEntityToWhisky(entity);
            whiskys.add(whisky);
        }
        return whiskys;
    }

    //METHODE POUR AVOIR UN WHISKY PAR SON ID
    public Whisky getWhiskyById(int id)
    {
        WhiskyEntity whiskyEntity = whiskyRepository.findById(id);
        return providerConverter.whiskyEntityToWhisky(whiskyEntity);
    }



}
