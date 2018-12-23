package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.Constants;
import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

import java.util.Locale;

@Controller
@RequestMapping
public class LoginController {
    private UserDAO userDAO;
    private final MessageSource messageSource;


    @Autowired
    public LoginController(UserDAO userDAO, MessageSource messageSource) {
        this.userDAO = userDAO;
        this.messageSource = messageSource;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String home (Model model, Locale locale) {
        model.addAttribute("user", new User());
        return "integrated:login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Authentication authentication)
    {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();

        return userDetails.getUsername();
    }

}
