package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Whisky;
import org.hibernate.Session;
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

    public ArrayList<Whisky> getAllWhiskyOrderByNameAsc(){
        return whiskiesModelAsList(whiskyRepository.findAllByOrderByWhiskyNameAsc());
    }
    public ArrayList<Whisky> getAllWhiskyOrderByNameDesc(){
        return whiskiesModelAsList(whiskyRepository.findAllByOrderByWhiskyNameDesc());
    }
    public ArrayList<Whisky> getAllWhiskyOrderByPriceAsc(){
        return whiskiesModelAsList(whiskyRepository.findAllByOrderByPriceAsc());
    }
    public ArrayList<Whisky> getAllWhiskyOrderByPriceDesc(){
        return whiskiesModelAsList(whiskyRepository.findAllByOrderByPriceDesc());
    }

    public ArrayList<Whisky> getWhiskyByCategorieOrderByNameAsc(String categorie){
        return whiskiesModelAsList(whiskyRepository.findByCategorieNomOrderByWhiskyNameAsc(categorie));
    }
    public ArrayList<Whisky> getWhiskyByCategorieOrderByNameDesc(String categorie){
        return whiskiesModelAsList(whiskyRepository.findByCategorieNomOrderByWhiskyNameDesc(categorie));
    }
    public ArrayList<Whisky> getWhiskyByCategorieOrderByPriceAsc(String categorie){
        return whiskiesModelAsList(whiskyRepository.findByCategorieNomOrderByPriceAsc(categorie));
    }
    public ArrayList<Whisky> getWhiskyByCategorieOrderByPriceDesc(String categorie){
        return whiskiesModelAsList(whiskyRepository.findByCategorieNomOrderByPriceDesc(categorie));
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

    public void updateStockQuantity(int id, int newStockQuantity)
    {
        Whisky whisky = getWhiskyById(id);
        whisky.setStockQuantity(newStockQuantity);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(providerConverter.whiskyToWhiskyEntity(whisky));
        session.getTransaction().commit();
    }

}
