package com.whisky.henallux.whisky.controller;
import com.whisky.henallux.whisky.service.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.ControllerAdvice(annotations = Controller.class)
public class ControllerAdvice {
    private Panier panier;

    @Autowired
    public ControllerAdvice(Panier panier){ this.panier = panier;}

    public ControllerAdvice(){}

    @RequestMapping(method = RequestMethod.GET)
    public void home(Model model)
    {
        model.addAttribute("panier", panier);
    }

}
