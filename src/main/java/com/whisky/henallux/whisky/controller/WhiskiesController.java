package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/whiskies")
public class WhiskiesController {
    private WhiskyDAO whiskyDAO;

    @Autowired
    public WhiskiesController(WhiskyDAO whiskyDAO){
        this.whiskyDAO = whiskyDAO;
    }

    @RequestMapping
    public String getAllWhisky(Model model){

        model.addAttribute("whisky", whiskyDAO.getAllWhisky());
        return "integrated:whiskies";
    }

    @RequestMapping(value = "/SingleMalt")
    public String getAllSingleMalt(Model model){

        model.addAttribute("whisky", whiskyDAO.getWhiskyByCategorie("Single Malt"));
        return "integrated:whiskies";
    }

    @RequestMapping(value = "/BlendedMalt")
    public String getAllBlended(Model model){

        model.addAttribute("whisky", whiskyDAO.getWhiskyByCategorie("Blended Malt"));
        return "integrated:whiskies";
    }





    /* VA DANS SINGLE CONTROLLER QUAND ON CLIC SUR UN WHISKY A FAIRE PLUS TARD
    @RequestMapping(value = "/whiskies/{id}")
    public String getWhiskyById(Model model, @PathVariable(value = "id") int id)
    {
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(id));
        return "integrated:whiskies";
    }*/

}
