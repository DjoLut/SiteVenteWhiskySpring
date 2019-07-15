package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.CategorieEntity;

public class Whisky {
    private Integer id;
    private String whiskyName;
    private Integer age;
    private String selection;
    private String brand;
    private String region;
    private String country;
    private Integer productionDate;
    private Integer alcoholContent;
    private Integer volume;
    private Integer stockQuantity;
    private CategorieEntity categorie;
    private String img;
    private Double price;
    private Double promotion;

    public Whisky(){}

    public Whisky(Integer id, String whiskyName, Integer stockQuantity, Double price, Double promotion) {
        this.id = id;
        this.whiskyName = whiskyName;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.promotion = promotion;
    }
    public Whisky(Integer id, String whiskyName, Integer stockQuantity, Double price) {
        this.id = id;
        this.whiskyName = whiskyName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public Integer getStockQuantity() { return stockQuantity; }
    public Integer getVolume() { return volume; }
    public Integer getAlcoholContent() { return alcoholContent; }
    public Integer getProductionDate() { return productionDate; }
    public Integer getAge() { return age; }
    public Integer getId() { return id; }
    public Double getPromotion() { return promotion; }
    public Double getPrice() { return price; }
    public String getImg() { return img; }
    public CategorieEntity getCategorie() { return categorie; }
    public String getBrand() { return brand;}
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getSelection() { return selection;}
    public String getWhiskyName() { return whiskyName; }

    public void setPromotion(Double promotion) { this.promotion = promotion; }
    public void setId(Integer id) { this.id = id; }
    public void setPrice(Double price) { this.price = price; }
    public void setImg(String img) { this.img = img; }
    public void setCategorie(CategorieEntity categorie) { this.categorie = categorie; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public void setVolume(Integer volume) { this.volume = volume; }
    public void setAlcoholContent(Integer alcoholContent) { this.alcoholContent = alcoholContent; }
    public void setProductionDate(Integer productionDate) { this.productionDate = productionDate; }
    public void setCountry(String country) { this.country = country; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setSelection(String selection) { this.selection = selection; }
    public void setAge(Integer age) { this.age = age; }
    public void setWhiskyName(String whiskyName) { this.whiskyName = whiskyName; }
    public void setRegion(String region) { this.region = region;}
}
