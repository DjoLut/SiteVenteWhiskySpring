package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="whiskyorder")
public class OrderEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="dateOrder")
    private Date dateOrder;
    @Column (name="validity")
    private boolean validity;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "utilisateur")
    private UserEntity utilisateur;
    @Column(name="promotion")
    private double promotion;
    @Column(name="totalprice")
    private double totalprice;
    @OneToMany(mappedBy = "whiskyorder",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CommandLineEntity> commandlines;

    public OrderEntity(){}

    public String getId(){return this.id;}
    public Date getDateOrder() { return dateOrder; }
    public boolean isValidity() { return validity; }
    public UserEntity getUtilisateur() { return utilisateur; }
    public double getPromotion() { return promotion; }
    public double getTotalPrice() { return totalprice; }
    public Set<CommandLineEntity> getCommandlines() { return commandlines; }

    public void setId(String id) { this.id = id; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setUtilisateur(UserEntity utilisateur) { this.utilisateur = utilisateur; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setTotalPrice(double totalprice) { this.totalprice = totalprice; }
    public void setCommandlines(Set<CommandLineEntity> commandlines) { this.commandlines = commandlines; }
}
