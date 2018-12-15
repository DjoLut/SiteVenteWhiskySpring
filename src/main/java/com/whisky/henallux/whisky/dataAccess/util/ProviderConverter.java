package com.whisky.henallux.whisky.dataAccess.util;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.model.Whisky;

public class ProviderConverter {

    //METHODE POUR CONVERTIR UN OBJET DE TYPE USERENTITY EN OBJET DE TYPE USER
    /*public UserEntity userModelToUserEntity(User user)
    {
        ;
    }*/

    //PAREIL MAIS INVERSEMENT
    /*public User userEntityToUserModel(UserEntity userEntity)
    {
        ;
    }*/

    public WhiskyEntity WhiskyToWhiskyEntity(Whisky whisky){
        WhiskyEntity whiskyEntity = new WhiskyEntity();
        whiskyEntity.setAge(whisky.getAge());
        whiskyEntity.setAlcoholContent(whisky.getAlcoholContent());
        whiskyEntity.setBrand(whisky.getBrand());
        whiskyEntity.setCategorie(whisky.getCategorie());
        whiskyEntity.setCountry(whisky.getCountry());
        whiskyEntity.setWhiskyName(whisky.getWhiskyName());
        whiskyEntity.setId(whisky.getId());
        whiskyEntity.setImg(whisky.getImg());
        whiskyEntity.setPrice(whisky.getPrice());
        whiskyEntity.setProductionDate(whisky.getProductionDate());
        whiskyEntity.setPromotion(whisky.getPromotion());
        whiskyEntity.setRegion(whisky.getRegion());
        whiskyEntity.setSelection(whisky.getSelection());
        whiskyEntity.setStockQuantity(whisky.getStockQuantity());
        whiskyEntity.setVolume(whisky.getVolume());
        return whiskyEntity;
    }

    public Whisky WhiskyEntityToWhisky(WhiskyEntity whiskyEntity){
        Whisky whisky = new Whisky();
        whisky.setBrand(whiskyEntity.getBrand());
        whisky.setAge(whiskyEntity.getAge());
        whisky.setAlcoholContent(whiskyEntity.getAlcoholContent());
        whisky.setCategorie(whiskyEntity.getCategorie());
        whisky.setCountry(whiskyEntity.getCountry());
        whisky.setId(whiskyEntity.getId());
        whisky.setImg(whiskyEntity.getImg());
        whisky.setPrice(whiskyEntity.getPrice());
        whisky.setProductionDate(whiskyEntity.getProductionDate());
        whisky.setPromotion(whiskyEntity.getPromotion());
        whisky.setCategorie(whiskyEntity.getCategorie());
        whisky.setRegion(whiskyEntity.getRegion());
        whisky.setStockQuantity(whiskyEntity.getStockQuantity());
        whisky.setSelection(whiskyEntity.getSelection());
        whisky.setVolume(whiskyEntity.getVolume());
        whisky.setWhiskyName(whiskyEntity.getWhiskyName());
        return whisky;
    }
}
