package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.exception.AlreadyLoginException;
import com.whisky.henallux.whisky.model.Panier;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import static com.whisky.henallux.whisky.controller.CheckoutController.PANIER;

@Controller
@RequestMapping(value="/register")
@SessionAttributes({"mainPanier"})
public class RegisterController {

    private UserDAO userDAO;
    private UserValidator userValidator;
    private CategorieDAO categorieDAO;

    @Autowired
    public RegisterController(UserDAO userDAO,UserValidator userValidator, CategorieDAO categorieDAO)
    {
        this.userDAO = userDAO;
        this.userValidator = userValidator;
        this.categorieDAO = categorieDAO;
    }

    @ModelAttribute(PANIER)
    public Panier getPanier()
    {
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (HttpServletRequest request, Model model) {
        if(request.getUserPrincipal() != null)
        {
            throw new AlreadyLoginException();
        }
        model.addAttribute("user", new User());
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
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
