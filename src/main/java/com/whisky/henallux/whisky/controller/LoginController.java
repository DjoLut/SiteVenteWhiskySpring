package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/login")

public class LoginController {


    private UserDAO userDAO;


    public LoginController(UserDAO userDAO) {this.userDAO = userDAO;}

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());
        return "integrated:login";
    }


    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(Model model,@Valid @ModelAttribute(value="user") User form ) {
        if(userDAO.userExist(form.getUsername(),new BCryptPasswordEncoder().encode(form.getPwd()))) {

            return "redirect:/index";
        }
        else
            return "redirect:/KeyError";
    }
}
