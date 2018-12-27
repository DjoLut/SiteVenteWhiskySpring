package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WhiskiesController {
    private WhiskyDAO whiskyDAO;

    @Autowired
    public WhiskiesController(WhiskyDAO whiskyDAO){
        this.whiskyDAO = whiskyDAO;
    }

    @RequestMapping(value = "/whiskies")
    public String home(Model model){

        model.addAttribute("whisky", whiskyDAO.getAllWhisky());
        return "integrated:whiskies";
    }
}
