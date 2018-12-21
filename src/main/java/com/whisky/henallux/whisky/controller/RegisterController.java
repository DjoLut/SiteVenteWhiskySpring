package com.whisky.henallux.whisky.controller;


import com.whisky.henallux.whisky.Constants;
import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/register")
@SessionAttributes({Constants.CURRENT_USER})
public class RegisterController {
    private UserDAO userDAO;

    @ModelAttribute(Constants.CURRENT_USER)
    public User user()
    {
        return new User();
    }

    @Autowired
    public RegisterController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());
        return "integrated:register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value=Constants.CURRENT_USER) User user,
                              final BindingResult errors){
        if(!errors.hasErrors()) {
            userDAO.save(user);
            return "redirect:/login";
        }

        return "integrated:register";
    }

}
