package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.service.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/whiskies")
public class WhiskiesController {
    private WhiskyDAO whiskyDAO;
    private Panier panier;

    @Autowired
    public WhiskiesController(WhiskyDAO whiskyDAO, Panier panier){
        this.whiskyDAO = whiskyDAO;
        this.panier = panier;
    }

    @RequestMapping
    public String getAllWhisky(Model model){

        model.addAttribute("whisky", whiskyDAO.getAllWhisky());
        return "integrated:whiskies";
    }

    @RequestMapping(value = "/{categorie}")
    public String getAllSingleMalt(Model model, @PathVariable(value = "categorie") String categorie){

        model.addAttribute("whisky", whiskyDAO.getWhiskyByCategorie(categorie));
        return "integrated:whiskies";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWhisky(HttpServletRequest request)
    {
        panier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/whiskies";
    }
}
