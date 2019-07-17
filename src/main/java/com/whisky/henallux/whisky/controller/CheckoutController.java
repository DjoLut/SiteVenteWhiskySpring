package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.dataAccess.dao.OrderDAO;
import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/checkout")
@SessionAttributes({CheckoutController.PANIER})
public class CheckoutController {

    private WhiskyDAO whiskyDAO;
    private OrderDAO orderDAO;
    private CategorieDAO categorieDAO;
    protected static final String PANIER = "mainPanier";

    @Autowired
    public CheckoutController(WhiskyDAO whiskyDAO, OrderDAO orderDAO, CategorieDAO categorieDAO)
    {
        this.whiskyDAO = whiskyDAO;
        this.orderDAO = orderDAO;
        this.categorieDAO = categorieDAO;
    }

    @ModelAttribute(PANIER)
    public Panier getPanier()
    {
        return new Panier();
    }

    @RequestMapping
    public String home(Model model, @ModelAttribute(value = PANIER) Panier mainPanier)
    {
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:checkout";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteWhisky(HttpServletRequest request, @ModelAttribute(value = PANIER) Panier mainPanier)
    {
        mainPanier.deleteWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))));
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyQuantity(HttpServletRequest request, @ModelAttribute(value = PANIER) Panier mainPanier)
    {
        if (request.getParameter("quantity") != "")
            mainPanier.modifyWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/validate")
    public String validatePanier(HttpServletRequest request, @ModelAttribute(value = PANIER) Panier mainPanier)
    {
        if(mainPanier.size() != 0)
        {
            if(request.getUserPrincipal() != null)
            {
                orderDAO.addPanier(mainPanier);
                mainPanier.deleteAll();
                return "redirect:/payementOk";
            }
            else
            {
                return "redirect:/login";
            }
        }

        return "redirect:/whiskies";
    }

    @RequestMapping(value = "/delete")
    public String deleteWhisky(@ModelAttribute(value = PANIER) Panier mainPanier)
    {
        mainPanier.deleteAll();
        return "redirect:/checkout";
    }

}
