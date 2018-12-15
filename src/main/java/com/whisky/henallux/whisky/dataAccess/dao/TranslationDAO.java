package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.TranslationEntity;
import com.whisky.henallux.whisky.dataAccess.entity.TranslationKey;
import com.whisky.henallux.whisky.dataAccess.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TranslationDAO {
    private TranslationRepository translationRepository;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository){
        this.translationRepository = translationRepository;
    }
}
