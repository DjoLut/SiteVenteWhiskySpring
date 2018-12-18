package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commandline")
public class CommandLineEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="realprice")
    private double realPrice;
    @Column(name="quantity")
    private int quantity;
    @Column(name="whiskyorder")
    private String order;
    @Column(name="whisky")
    private Integer whisky;

    public void setRealPrice(double realPrice) { this.realPrice = realPrice;}
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setOrder(String order) { this.order = order; }
    public String getOrder() { return order; }
    public int getQuantity() { return quantity; }
    public double getRealPrice() { return realPrice; }
    public void setId(String id) { this.id = id; }
    public String getId() { return id; }
    public Integer getWhisky() { return whisky; }
    public void setWhisky(Integer whisky) { this.whisky = whisky; }
}
