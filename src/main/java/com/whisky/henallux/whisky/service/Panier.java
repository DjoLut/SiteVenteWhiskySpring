package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.dataAccess.repository.WhiskyRepository;
import com.whisky.henallux.whisky.model.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class Panier {

    private Map<Whisky, Integer> whiskys;
    private WhiskyRepository whiskyRepository;

    @Autowired
    public Panier(WhiskyRepository whiskyRepository)
    {
        whiskys = new HashMap<>();
        this.whiskyRepository = whiskyRepository;
    }

    public void addWhisky(Whisky whisky, int quantity)
    {
        if(!whiskys.containsKey(whisky))
            whiskys.put(whisky, quantity);
        else {
            int quantiteOld = whiskys.get(whisky);
            whiskys.replace(whisky, quantiteOld, quantity+quantiteOld);
        }
    }

    public void deleteWhisky(Whisky whisky)
    {
        whiskys.clear();
    }

    public Map<Whisky, Integer> getWhiskys() {
        return whiskys;
    }

    public void setWhiskys(Map<Whisky, Integer> whiskys) {
        this.whiskys = whiskys;
    }

}
