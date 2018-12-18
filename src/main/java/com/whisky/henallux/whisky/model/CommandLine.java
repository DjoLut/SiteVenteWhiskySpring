package com.whisky.henallux.whisky.model;

public class CommandLine {
    private String id;
    private double realPrice;
    private int quantity;
    private Order order;
    private Whisky whisky;

    public void setWhisky(Whisky whisky) { this.whisky = whisky; }
    public Whisky getWhisky() { return whisky; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getRealPrice() { return realPrice;}
    public int getQuantity() { return quantity; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setRealPrice(double realPrice) { this.realPrice = realPrice; }
}
