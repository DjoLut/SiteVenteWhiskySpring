package com.whisky.henallux.whisky.dataAccess.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whisky")
public class WhiskyEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="whiskyname")
    private String whiskyName;
    @Column(name="age")
    private int age;
    @Column(name="selection")
    private String selection;
    @Column(name="brand")
    private String brand;
    @Column(name="region")
    private String region;
    @Column(name = "country")
    private String country;
    @Column(name="productiondate")
    private int productionDate;
    @Column(name="alcoholContent")
    private int alcoholContent;
    @Column(name="volume")
    private int volume;
    @Column(name="stockquantity")
    private int stockQuantity;
    @Column(name="categorie")
    private String categorie;
    @Column(name="img")
    private String img;
    @Column(name="price")
    private double price;
    @Column(name="promotion")
    private double promotion;

    public WhiskyEntity(){}

    public Integer getId(){return this.id;}
    public String getWhiskyName(){return this.whiskyName;}
    public Integer getAge(){return this.age;}
    public String getSelection(){return this.selection;}
    public String getBrand() {return brand; }
    public String getRegion() { return region; }
    public String getCountry() { return country; }
    public Integer getProductionDate() { return productionDate; }
    public Integer getAlcoholContent() { return alcoholContent; }
    public Integer getVolume() { return volume; }
    public Integer getStockQuantity() { return stockQuantity; }
    public String getCategorie() { return categorie; }
    public String getImg() { return img; }
    public double getPrice() { return price; }
    public double getPromotion() { return promotion; }

    public void setId(Integer id) { this.id = id; }
    public void setWhiskyName(String whiskyName) { this.whiskyName = whiskyName; }
    public void setAge(Integer age) { this.age = age; }
    public void setSelection(String selection) { this.selection = selection; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setRegion(String region) { this.region = region; }
    public void setCountry(String country) { this.country = country; }
    public void setProductionDate(Integer productionDate) { this.productionDate = productionDate; }
    public void setAlcoholContent(Integer alcoholContent) { this.alcoholContent = alcoholContent; }
    public void setVolume(Integer volume) { this.volume = volume; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public void setImg(String img) { this.img = img; }
    public void setPrice(double price) { this.price = price; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
}
