package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="whisky")
public class WhiskyEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="whiskyname")
    private String whiskyName;
    @Column(name="age")
    private Integer age;
    @Column(name="selection")
    private String selection;
    @Column(name="brand")
    private String brand;
    @Column(name="region")
    private String region;
    @Column(name = "country")
    private String country;
    @Column(name="productiondate")
    private Integer productionDate;
    @Column(name="alcoholcontent")
    private Integer alcoholContent;
    @Column(name="volume")
    private Integer volume;
    @Column(name="stockquantity")
    private Integer stockQuantity;
    @JoinColumn(name = "categorie", referencedColumnName = "nom")
    @ManyToOne
    private CategorieEntity categorie;
    @Column(name="img")
    private String img;
    @Column(name="price")
    private Double price;
    @Column(name="promotion")
    private Double promotion;
    @OneToMany(mappedBy = "whisky",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<CommandLineEntity> commandlines;
    @OneToMany(mappedBy = "whiskyid",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TranslationEntity> translationEntities;


    public WhiskyEntity(){}

    public Collection<TranslationEntity> getTranslationEntities() { return translationEntities; }
    public void setTranslationEntities(Collection<TranslationEntity> translationEntities) { this.translationEntities = translationEntities; }

    public Collection<CommandLineEntity> getCommandlines() { return commandlines; }
    public void setCommandlines(Collection<CommandLineEntity> commandlines) {this.commandlines = commandlines; }

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
    public CategorieEntity getCategorie() { return categorie; }
    public String getImg() { return img; }
    public Double getPrice() { return price; }
    public Double getPromotion() { return promotion; }

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
    public void setCategorie(CategorieEntity categorie) { this.categorie = categorie; }
    public void setImg(String img) { this.img = img; }
    public void setPrice(Double price) { this.price = price; }
    public void setPromotion(Double promotion) { this.promotion = promotion; }
}
