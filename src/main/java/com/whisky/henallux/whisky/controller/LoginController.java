package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.exception.AlreadyLoginException;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class LoginController {

    private CategorieDAO categorieDAO;

    @Autowired
    public LoginController(CategorieDAO categorieDAO)
    {
        this.categorieDAO = categorieDAO;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {

        if(request.getUserPrincipal() != null)
        {
            throw new AlreadyLoginException();
        }

        model.addAttribute("user", new User());
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public void getUserAuth(Authentication authentication)
    {
        authentication.getPrincipal();
    }

}
