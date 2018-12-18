package com.whisky.henallux.whisky.model;



public class Whisky {
    private Integer id;
    private String whiskyName;
    private int age;
    private String selection;
    private String brand;
    private String region;
    private String country;
    private int productionDate;
    private int alcoholContent;
    private int volume;
    private int stockQuantity;
    private Categorie categorie;
    private String img;
    private double price;
    private double promotion;

    public Whisky(){}


    public int getStockQuantity() { return stockQuantity; }
    public int getVolume() { return volume; }
    public int getAlcoholContent() { return alcoholContent; }
    public int getProductionDate() { return productionDate; }
    public int getAge() { return age; }
    public Integer getId() { return id; }
    public double getPromotion() { return promotion; }
    public double getPrice() { return price; }
    public String getImg() { return img; }
    public Categorie getCategorie() { return categorie; }
    public String getBrand() { return brand;}
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getSelection() { return selection;}
    public String getWhiskyName() { return whiskyName; }

    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setId(Integer id) { this.id = id; }
    public void setPrice(double price) { this.price = price; }
    public void setImg(String img) { this.img = img; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public void setVolume(int volume) { this.volume = volume; }
    public void setAlcoholContent(int alcoholContent) { this.alcoholContent = alcoholContent; }
    public void setProductionDate(int productionDate) { this.productionDate = productionDate; }
    public void setCountry(String country) { this.country = country; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setSelection(String selection) { this.selection = selection; }
    public void setAge(int age) { this.age = age; }
    public void setWhiskyName(String whiskyName) { this.whiskyName = whiskyName; }
    public void setRegion(String region) { this.region = region;}
}
