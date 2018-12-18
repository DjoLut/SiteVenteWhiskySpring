package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="whiskyorder")
public class OrderEntity {
    @Id
    @Column(name="whiskyorderid")
    private String whiskyorderid;
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
    @OneToMany(mappedBy = "whiskyorder",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CommandLineEntity> commandlines;

    public OrderEntity(){}

    public String getWhiskyorderid(){return this.whiskyorderid;}
    public Date getDateOrder() { return dateOrder; }
    public boolean isValidity() { return validity; }
    public UserEntity getUsername() { return username; }
    public double getPromotion() { return promotion; }
    public double getTotalPrice() { return totalPrice; }
    public Set<CommandLineEntity> getCommandlines() { return commandlines; }

    public void setWhiskyorderid(String whiskyorderid) { this.whiskyorderid = whiskyorderid; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setUsername(UserEntity username) { this.username = username; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setCommandlines(Set<CommandLineEntity> commandlines) { this.commandlines = commandlines; }
}
