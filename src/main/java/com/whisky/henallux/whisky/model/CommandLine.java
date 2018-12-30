package com.whisky.henallux.whisky.model;

public class CommandLine {
    private String id;
    private Double realPrice;
    private int quantity;
    private Order whiskyorder;
    private Whisky whisky;

    public void setWhisky(Whisky whisky) { this.whisky = whisky; }
    public Whisky getWhisky() { return whisky; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Double getRealPrice() { return realPrice;}
    public int getQuantity() { return quantity; }
    public Order getWhiskyOrder() { return whiskyorder; }
    public void setWhiskyOrder(Order whiskyorder) { this.whiskyorder = whiskyorder; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setRealPrice(Double realPrice) { this.realPrice = realPrice; }
}
