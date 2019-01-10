package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.model.Whisky;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PanierTest {

    @Mock
    private Map<Whisky, Integer> whiskys;

    private Panier service;

    @Before
    public void setUp() throws Exception {
        service = new Panier();
    }

    @Test
    public void calculTotalPrice() throws Exception {
        Assert.assertEquals(118.3, service.calculTotalPrice(), 1.0);
    }

    @Test
    public void calculTotalPromo() throws Exception {
        Assert.assertEquals(4.95, service.calculTotalPromo(), 1.0);
    }
}