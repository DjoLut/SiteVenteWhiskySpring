package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/single")
public class SingleController {
    private WhiskyDAO whiskyDAO;

    @Autowired
    public SingleController(WhiskyDAO whiskyDAO){
        this.whiskyDAO = whiskyDAO;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getWhiskyById(Model model, @PathVariable(value = "id") int id)
    {
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(id));
        return "integrated:single";
    }

}