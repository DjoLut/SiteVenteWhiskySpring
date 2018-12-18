package com.whisky.henallux.whisky.model;

public class CommandLine {
    private String id;
    private double realPrice;
    private int quantity;
    private String order;
    private Integer whisky;

    public void setWhisky(Integer whisky) { this.whisky = whisky; }
    public Integer getWhisky() { return whisky; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getRealPrice() { return realPrice;}
    public int getQuantity() { return quantity; }
    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setRealPrice(double realPrice) { this.realPrice = realPrice; }
}
