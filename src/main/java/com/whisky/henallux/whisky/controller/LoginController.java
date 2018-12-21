package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.Constants;
import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping
public class LoginController {
    private UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {this.userDAO = userDAO;}

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("user", new User());

        return "integrated:login";
    }

    /*@RequestMapping(method=RequestMethod.GET)
    public String getFormData(@ModelAttribute(value=Constants.CURRENT_USER) User form,
                              final BindingResult errors) {
        if(userDAO.userExist(form.getUsername(), new BCryptPasswordEncoder().encode(form.getPassword())))
        {
            return "integrated:index";
        }

        return "redirect:/KeyError";
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String home(Authentication authentication)
    {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();

        return userDetails.getUsername();
    }

}
