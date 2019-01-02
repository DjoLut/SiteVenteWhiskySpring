package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="whiskyorder")
public class OrderEntity {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    @Column(name="dateorder")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;
    @Column (name="validity")
    private boolean validity;
    @JoinColumn(name = "utilisateur", referencedColumnName = "username")
    @ManyToOne
    private UserEntity utilisateur;
    @Column(name="promotion")
    private double promotion;
    @Column(name="totalprice")
    private double totalprice;
    @OneToMany(mappedBy = "whiskyorder")
    private Collection<CommandLineEntity> commandlines;

    public OrderEntity(){}

    public Integer getId(){return this.id;}
    public Date getDateOrder() { return dateOrder; }
    public boolean isValidity() { return validity; }
    public UserEntity getUtilisateur() { return utilisateur; }
    public double getPromotion() { return promotion; }
    public double getTotalPrice() { return totalprice; }
    public Collection<CommandLineEntity> getCommandlines() { return commandlines; }

    public void setId(Integer id) { this.id = id; }
    public void setDateOrder(Date dateOrder) { this.dateOrder = dateOrder; }
    public void setValidity(boolean validity) { this.validity = validity; }
    public void setUtilisateur(UserEntity utilisateur) { this.utilisateur = utilisateur; }
    public void setPromotion(double promotion) { this.promotion = promotion; }
    public void setTotalPrice(double totalprice) { this.totalprice = totalprice; }
    public void setCommandlines(Collection<CommandLineEntity> commandlines) { this.commandlines = commandlines; }
}
