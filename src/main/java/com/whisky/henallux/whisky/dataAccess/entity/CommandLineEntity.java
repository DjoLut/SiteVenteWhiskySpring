package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="commandline")
public class CommandLineEntity {
    @Id
    @Column(name="commandlineid")
    private String commandlineid;
    @Column(name="realprice")
    private double realprice;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "whiskyorder", referencedColumnName = "whiskyorderid")
    private OrderEntity whiskyorder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "whisky", referencedColumnName = "id")
    private WhiskyEntity whisky;

    public void setRealprice(double realprice) { this.realprice = realprice;}
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return quantity; }
    public double getRealprice() { return realprice; }
    public void setWhiskyorder(OrderEntity whiskyorder) { this.whiskyorder = whiskyorder; }
    public OrderEntity getWhiskyorder() { return whiskyorder; }
    public WhiskyEntity getWhisky() { return whisky; }
    public void setWhisky(WhiskyEntity whisky) { this.whisky = whisky; }
    public void setCommandlineid(String commandlineid) { this.commandlineid = commandlineid; }
    public String getCommandlineid() { return commandlineid; }
}
