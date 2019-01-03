package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface LanguageRepository extends JpaRepository<LanguageEntity,String> {
    LanguageEntity findById(String id);
}
