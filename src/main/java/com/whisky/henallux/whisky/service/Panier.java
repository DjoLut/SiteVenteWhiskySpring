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

                whiskyPresent = true;
                break;
            }
        }

        if(!whiskyPresent)
            whiskys.put(whisky, quantity);

    }

    public int size(){ return this.whiskys.size();}

    public double totalPriceWhisky(){
        double count = 0.0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Whisky, Integer> entry = it.next();
            count+= entry.getValue()*(entry.getKey().getPrice()-entry.getKey().getPrice()*(entry.getKey().getPromotion()/100));
        }
        return count;
    }

    public int countWhisky(){
        int count = 0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();)
            count += it.next().getValue();
        return count;
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

    public double calculTotalPrice()
    {
        double totalPrice = 0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            totalPrice += (entry.getKey().getPrice()*entry.getValue());
        }
        return totalPrice;
    }

    public double calculTotalPromo()
    {
        double totalPromo = 0;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            if(entry.getKey().getPromotion() != null)
                totalPromo += (entry.getKey().getPromotion()/100*entry.getKey().getPrice()*entry.getValue());
        }
        return totalPromo;
    }

}
