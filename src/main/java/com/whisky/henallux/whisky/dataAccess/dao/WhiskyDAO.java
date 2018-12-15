package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WhiskyDAO {
    private WhiskyRepository whiskyRepository;

    @Autowired
    public WhiskyDAO(WhiskyRepository whiskyRepository){
        this.whiskyRepository=whiskyRepository;
    }
    public ArrayList<String> getWhiskyName(){
        List<WhiskyEntity> whiskyEntities = whiskyRepository.findAll();
        ArrayList<String> list = new ArrayList<>();
        for(WhiskyEntity whiskyEntity : whiskyEntities)
            list.add(whiskyEntity.getWhiskyName());
        return list;
    }
}
