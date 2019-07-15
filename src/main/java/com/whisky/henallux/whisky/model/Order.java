package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import java.util.Date;

public class Order {
    private Integer id;
    private Date dateOrder;
    private Boolean validity;
    private UserEntity utilisateur;
    private Double promotion;
    private Double totalprice;

    public Order(){}

    public Double getPromotion() { return promotion; }
    public UserEntity getUtilisateur() { return utilisateur;}
    public Boolean isValidity() { return validity; }
    public Double getTotalPrice() { return totalprice; }
    public Date getDateOrder() { return dateOrder; }
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    public void setPromotion(Double promotion) { this.promotion = promotion; }
    public void setUtilisateur(UserEntity utilisateur) { this.utilisateur = utilisateur; }
    public void setValidity(Boolean validity) { this.validity = validity; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder;}
    public void setTotalPrice(Double totalprice) { this.totalprice = totalprice; }
}
