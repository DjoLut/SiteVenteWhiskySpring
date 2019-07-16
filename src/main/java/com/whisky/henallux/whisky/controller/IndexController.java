package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class IndexController {

    private WhiskyDAO whiskyDAO;
    private CategorieDAO categorieDAO;

    @Autowired
    public IndexController(WhiskyDAO whiskyDAO, CategorieDAO categorieDAO)
    {
        this.whiskyDAO = whiskyDAO;
        this.categorieDAO = categorieDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model)
    {
        model.addAttribute("whisky", whiskyDAO.getAllWhisky());
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:index";
    }
}
