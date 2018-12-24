package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.Validator.UserValidator;
import com.whisky.henallux.whisky.dataAccess.dao.UserDAO;
import com.whisky.henallux.whisky.model.User;
import com.whisky.henallux.whisky.service.SecurityService;
import com.whisky.henallux.whisky.service.SecurityServiceImpl;
import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.security.Security;
import java.util.Locale;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
    private UserDAO userDAO;
    private MessageSource messageSource;
    private UserValidator userValidator;

    @Autowired
    public RegisterController(UserDAO userDAO, MessageSource messageSource,UserValidator userValidator){
        this.userDAO = userDAO;
        this.messageSource = messageSource;
        this.userValidator = userValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, Locale locale) {
        model.addAttribute("user", new User());
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute(value="user") User user,
                              final BindingResult errors){
        userValidator.validate(user,errors);
        if(errors.hasErrors()) {
            model.addAttribute(errors);
            return "integrated:register";
        }

        userDAO.saveNewUser(user);
        new SecurityServiceImpl().autoLogin(user.getUsername(),user.getPassword());
        return "redirect:/index";
    }

}
