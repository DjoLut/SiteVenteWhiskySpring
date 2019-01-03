package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.LanguageEntity;
import com.whisky.henallux.whisky.dataAccess.repository.LanguageRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Locale;

@Service
@Transactional
public class LanguageDAO {

    private LanguageRepository languageRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderConverter providerConverter)
    {
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }


    public Language getLanguageById(String id)
    {
        LanguageEntity languageEntity = languageRepository.findById(id);
        return providerConverter.languageEntityToLanguage(languageEntity);
    }

}
