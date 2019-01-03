package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.LanguageEntity;
import com.whisky.henallux.whisky.dataAccess.entity.TranslationEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer>{
    TranslationEntity findByWhiskyidAndAndLanguageid(WhiskyEntity whiskyid, LanguageEntity languageid);
}
