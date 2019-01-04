package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.model.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class Panier {

    private Map<Whisky, Integer> whiskys;

    @Autowired
    public Panier()
    {
        whiskys = new HashMap<>();
    }

    public Map<Whisky, Integer> getWhiskys() {
        return whiskys;
    }

    public void setWhiskys(Map<Whisky, Integer> whiskys) {
        this.whiskys = whiskys;
    }

    public void addWhisky(Whisky whisky, int quantity)
    {
        Boolean whiskyPresent = false;
        int quantityOld;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            if (entry.getKey().getId() == whisky.getId())
            {
                if((entry.getKey().getStockQuantity()-entry.getValue()) > 0)
                {
                    quantityOld = entry.getValue();
                    it.remove();
                    whiskys.put(whisky, quantity+quantityOld);
                }
                else
                {
                    //MESSAGE : PLUS D'ARTICLES OU QUANTITYARTICLES RESTANTES !!!
                }
                whiskyPresent = true;
                break;
            }
        }

        if(!whiskyPresent)
            whiskys.put(whisky, quantity);

    }

    public void deleteWhisky(Whisky whisky)
    {
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            if (entry.getKey().getId() == whisky.getId())
            {
                it.remove();
                break;
            }
        }
    }

    public void modifyWhisky(Whisky whisky, int quantity)
    {
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            if (entry.getKey().getId() == whisky.getId())
            {
                it.remove();
                whiskys.put(whisky, quantity);
                break;
            }
        }
    }

    public void deleteAll()
    {
        whiskys.clear();
    }

    public double calculPrice()
    {
        double totalPrice = 0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            totalPrice += (entry.getKey().getPrice()*entry.getValue());
        }
        return totalPrice;
    }

    public double calculPromo()
    {
        double totalPromo = 0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            totalPromo += (entry.getKey().getPrice()*entry.getValue()) / (entry.getKey().getPrice()*entry.getValue()*entry.getKey().getPromotion());
        }
        return totalPromo;
    }

}
