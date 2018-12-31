package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
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

    public void addWhisky(Whisky whisky, int quantity)
    {
        Boolean whiskyPresent = false;
        int quantityOld;
        for(Iterator<Map.Entry<Whisky,Integer>> it = whiskys.entrySet().iterator(); it.hasNext();){
            Map.Entry<Whisky, Integer> entry = it.next();
            if (entry.getKey().getId() == whisky.getId())
            {
                quantityOld = entry.getValue();
                it.remove();
                whiskys.put(whisky, quantity+quantityOld);
                whiskyPresent = true;
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
            }
        }
    }

    public Map<Whisky, Integer> getWhiskys() {
        return whiskys;
    }

    public void setWhiskys(Map<Whisky, Integer> whiskys) {
        this.whiskys = whiskys;
    }

}
