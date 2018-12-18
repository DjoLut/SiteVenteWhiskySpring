package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
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
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "username")
    private UserEntity username;
    @Column(name="promotion")
    private double promotion;
    @Column(name="totalPrice")
    private double totalPrice;

    public OrderEntity(){}

    public String getId(){return this.id;}
    public Date getDateOrder() { return dateOrder; }
    public boolean isValidity() { return validity; }
    public UserEntity getUsername() { return username; }
    public double getPromotion() { return promotion; }
    public double getTotalPrice() { return totalPrice; }

    public void setId(String id) { this.id = id; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setUsername(UserEntity username) { this.username = username; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
