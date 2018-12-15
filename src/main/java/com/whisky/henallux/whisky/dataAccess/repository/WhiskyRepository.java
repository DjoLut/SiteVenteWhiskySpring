package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.model.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<WhiskyEntity, Integer> {
    /*public List<WhiskyEntity> findAllByOrOrderByPrice();
    public List<WhiskyEntity> findAllByOrOrderByCategorie();
    public List<WhiskyEntity> findAllByPromotionIsNotNull();
    public List<WhiskyEntity> findAllByStockQuantityIsNotNull();
    public List<WhiskyEntity> findAllByPriceBetween(double nombre1, double nombre2);*/

}
