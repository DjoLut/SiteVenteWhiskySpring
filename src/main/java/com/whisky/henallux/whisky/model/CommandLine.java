package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;

public class CommandLine {
    private Integer id;
    private Double realPrice;
    private int quantity;
    private OrderEntity whiskyorder;
    private WhiskyEntity whisky;

    public void setWhisky(WhiskyEntity whisky) { this.whisky = whisky; }
    public WhiskyEntity getWhisky() { return whisky; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Double getRealPrice() { return realPrice;}
    public int getQuantity() { return quantity; }
    public OrderEntity getWhiskyOrder() { return whiskyorder; }
    public void setWhiskyOrder(OrderEntity whiskyorder) { this.whiskyorder = whiskyorder; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setRealPrice(Double realPrice) { this.realPrice = realPrice; }
}
