package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WhiskiesController {
    /*private WhiskyDAO whiskyDAO;

    @Autowired
    public WhiskiesController(WhiskyDAO whiskyDAO){
        this.whiskyDAO = whiskyDAO;
    }*/

    @RequestMapping(value = "/whiskies", method = RequestMethod.GET)
    public String home(Model model){
        return "integrated:whiskies";
    }
}
