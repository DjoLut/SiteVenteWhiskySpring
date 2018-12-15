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
}
