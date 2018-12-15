package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="whiskyorder")
public class OrderEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="dateorder")
    private Date dateOrder;
    @Column (name="validity")
    private boolean validity;
    @Column(name="utilisateur")
    private String utilisateur;
    @Column(name="promotion")
    private double promotion;
    @Column(name="totalPrice")
    private double totalPrice;

    public OrderEntity(){}

    public String getId(){return this.id;}
    public Date getDateOrder() { return dateOrder; }
    public boolean isValidity() { return validity; }
    public String getUtilisateur() { return utilisateur; }
    public double getPromotion() { return promotion; }
    public double getTotalPrice() { return totalPrice; }

    public void setId(String id) { this.id = id; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setUtilisateur(String utilisateur) { this.utilisateur = utilisateur; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
