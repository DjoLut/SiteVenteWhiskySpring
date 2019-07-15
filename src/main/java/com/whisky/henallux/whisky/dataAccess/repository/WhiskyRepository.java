package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WhiskyRepository extends JpaRepository<WhiskyEntity, Integer> {
    List<WhiskyEntity> findAll();
    WhiskyEntity findById(int id);
    List<WhiskyEntity> findByCategorieNomOrderByWhiskyNameAsc(String categorie);
    List<WhiskyEntity> findByCategorieNomOrderByWhiskyNameDesc(String categorie);
    List<WhiskyEntity> findByCategorieNomOrderByPriceAsc(String categorie);
    List<WhiskyEntity> findByCategorieNomOrderByPriceDesc(String categorie);
    List<WhiskyEntity> findAllByOrderByWhiskyNameAsc();
    List<WhiskyEntity> findAllByOrderByWhiskyNameDesc();
    List<WhiskyEntity> findAllByOrderByPriceAsc();
    List<WhiskyEntity> findAllByOrderByPriceDesc();
}
