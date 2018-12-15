package com.whisky.henallux.whisky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/contact")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public String home () {
        return "integrated:contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(){
        return "";
    }
}