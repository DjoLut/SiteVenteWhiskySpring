package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
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
    /*public ArrayList<Whisky> getWhiskies(){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAll()); }
    public ArrayList<Whisky> getWhiskiesByPrice(){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAllByOrOrderByPrice()); }
    public ArrayList<Whisky> getWhiskiesByCategorie(){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAllByOrOrderByCategorie()); }
    public ArrayList<Whisky> getWhiskiesInPromotion(){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAllByPromotionIsNotNull()); }
    public ArrayList<Whisky> getWhiskiesInStock(){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAllByStockQuantityIsNotNull()); }
    public ArrayList<Whisky> getWhiskiesBetween(double nombre1, double nombre2){ return this.whiskyEntitiesToWhiskies(whiskyRepository.findAllByPriceBetween(nombre1,nombre2));}

    public Whisky getWhiskyEntity(Integer id){ return providerConverter.whiskyEntityToWhisky(whiskyRepository.findOne(id)); }

    private ArrayList<Whisky> whiskyEntitiesToWhiskies(List<WhiskyEntity> whiskyEntities){
        ArrayList<Whisky> whiskies = new ArrayList<>();
        for(WhiskyEntity whiskyEntity : whiskyEntities)
            whiskies.add(providerConverter.whiskyEntityToWhisky(whiskyEntity));
        return whiskies;
    }*/

    //METHODE POUR AVOIR TOUS LES WHISKY
    public ArrayList<Whisky> getAllWhisky()
    {
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findAll();
        ArrayList<Whisky> whiskys = new ArrayList<>();
        for(WhiskyEntity entity : whiskyEntities)
        {
            Whisky whisky = providerConverter.whiskyEntityToWhisky(entity);
            whiskys.add(whisky);
        }
        return whiskys;
    }

    //METHODE POUR AVOIR TOUS LES SINGLE MALT
    public ArrayList<Whisky> getWhiskyByCategorie(String categorie)
    {
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findByCategorieNom(categorie);
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
