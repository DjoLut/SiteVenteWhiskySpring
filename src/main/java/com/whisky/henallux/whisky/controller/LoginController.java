package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.exception.AlreadyLoginException;
import com.whisky.henallux.whisky.model.Panier;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import static com.whisky.henallux.whisky.controller.CheckoutController.PANIER;

@Controller
@RequestMapping
@SessionAttributes({"mainPanier"})
public class LoginController {

    private CategorieDAO categorieDAO;

    @Autowired
    public LoginController(CategorieDAO categorieDAO)
    {
        this.categorieDAO = categorieDAO;
    }

    @ModelAttribute(PANIER)
    public Panier getPanier()
    {
        return new Panier();
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
    public String getUserAuth(Authentication authentication)
    {
        authentication.getPrincipal();
        return "redirect:/index";
    }

}
