package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Whisky;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WhiskyDAO {
    private WhiskyRepository whiskyRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public WhiskyDAO(WhiskyRepository whiskyRepository, ProviderConverter providerConverter){
        this.whiskyRepository=whiskyRepository;
        this.providerConverter = providerConverter;
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

    public Whisky getWhisky(Integer id){ return providerConverter.whiskyEntityToWhisky(whiskyRepository.findOne(id)); }



    private ArrayList<Whisky> whiskyEntitiesToWhiskies(List<WhiskyEntity> whiskyEntities){
        ArrayList<Whisky> whiskies = new ArrayList<>();
        for(WhiskyEntity whiskyEntity : whiskyEntities)
            whiskies.add(providerConverter.whiskyEntityToWhisky(whiskyEntity));
        return whiskies;
    }*/
}
