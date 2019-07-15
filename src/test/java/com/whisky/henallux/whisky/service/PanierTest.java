package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.model.Whisky;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PanierTest {

    private Panier panier;
    private Whisky whisky1;
    private Whisky whisky2;
    private Whisky whisky3;

    @Before
    public void setUp() {
        panier = new Panier();
        whisky1 = new Whisky(1, "whisky1", 10, 39.5, 10);
        whisky2 = new Whisky(2, "whisky2", 5, 58.75);
        whisky3 = new Whisky(3, "whisky3", 35, 28.10, 5);
        panier.addWhisky(whisky1, 2);
        panier.addWhisky(whisky2, 4);
        panier.addWhisky(whisky3, 3);
    }

    @Test
    public void calculTotalPrice() {
        Assert.assertEquals(398.30, panier.calculTotalPrice(), 0.01);
    }

    @Test
    public void calculTotalPromo() {
        Assert.assertEquals(12.115, panier.calculTotalPromo(), 0.01);
    }

    @Test
    public void whiskyAjoutable() {
        Assert.assertEquals(8, panier.whiskyAjoutable(whisky1), 0.1);
    }

    @Test
    public void countWhisky() {
        Assert.assertEquals(9, panier.countWhisky(), 0.1);
    }

    @Test
    public void totalPriceWhisky() {
        Assert.assertEquals(386.185, panier.totalPriceWhisky(), 0.01);
    }

}