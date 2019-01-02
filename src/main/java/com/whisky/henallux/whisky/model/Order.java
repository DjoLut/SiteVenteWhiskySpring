package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import java.util.Date;

public class Order {
    private Integer id;
    private Date dateOrder;
    private boolean validity;
    private UserEntity utilisateur;
    private double promotion;
    private double totalprice;

    public Order(){}

    public double getPromotion() { return promotion; }
    public UserEntity getUtilisateur() { return utilisateur;}
    public boolean isValidity() { return validity; }
    public double getTotalPrice() { return totalprice; }
    public Date getDateOrder() { return dateOrder; }
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setUtilisateur(UserEntity utilisateur) { this.utilisateur = utilisateur; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder;}
    public void setTotalPrice(double totalprice) { this.totalprice = totalprice; }
}
