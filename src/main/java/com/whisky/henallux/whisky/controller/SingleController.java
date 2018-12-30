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
@RequestMapping(value="/single/{id}")
public class SingleController {
    private WhiskyDAO whiskyDAO;
    private Panier panier;

    @Autowired
    public SingleController(WhiskyDAO whiskyDAO, Panier panier)
    {
        this.whiskyDAO = whiskyDAO;
        this.panier = panier;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getWhiskyById(Model model, @PathVariable(value = "id") int id)
    {
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(id));
        return "integrated:single";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWhisky(HttpServletRequest request, Model model)
    {
        panier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))));
        return "integrated:single";
    }

}