package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.model.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class LoginController {
    private UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {this.userDAO = userDAO;}

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());

        return "integrated:login";
    }


    /*@RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="user") User form ) {
        if(userDAO.userExist(form.getUsername(), new BCryptPasswordEncoder().encode(form.getPassword())))
        {
            return "redirect:/index";
        }
        else {
            return "redirect:/KeyError";
        }
    }*/

    /*@RequestMapping(method = RequestMethod.GET)
    public String home(Authentication authentication)
    {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        return "";
    }*/

}
