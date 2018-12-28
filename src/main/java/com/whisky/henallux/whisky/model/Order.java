package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.CommandLineEntity;

import java.util.GregorianCalendar;
import java.util.Set;

public class Order {
    private String id;
    private GregorianCalendar dateOrder;
    private boolean validity;
    private User utilisateur;
    private double promotion;
    private double totalprice;
    public Order(){}

    public double getPromotion() { return promotion; }
    public User getUtilisateur() { return utilisateur;}
    public boolean isValidity() { return validity; }
    public double getTotalPrice() { return totalprice; }
    public GregorianCalendar getDateOrder() { return dateOrder; }
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setUtilisateur(User utilisateur) { this.utilisateur = utilisateur; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setDateOrder(GregorianCalendar dateOrder) { this.dateOrder = dateOrder;}
    public void setTotalPrice(double totalprice) { this.totalprice = totalprice; }
}
