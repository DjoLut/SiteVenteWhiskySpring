package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.validator.UserValidator;
import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
    private UserDAO userDAO;
    private UserValidator userValidator;

    @Autowired
    public RegisterController(UserDAO userDAO,UserValidator userValidator){
        this.userDAO = userDAO;
        this.userValidator = userValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute(value="user") User user, BindingResult errors){
        userValidator.validate(user, errors);
        if(!errors.hasErrors()){
            userDAO.saveNewUser(user);
            return "redirect:/login";
        }

        model.addAttribute(errors);
        return "integrated:register";
    }

}
