package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/description")
public class DescriptionController {

    private CategorieDAO categorieDAO;

    @Autowired
    public DescriptionController(CategorieDAO categorieDAO)
    {
        this.categorieDAO = categorieDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:description";
    }

}
