package com.whisky.henallux.whisky.controller;


import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
    private UserDAO userDAO;

    @Autowired
    public RegisterController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user",new User());
        return "integrated:register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="user") User user){
        return "redirect:/index";
    }

}
