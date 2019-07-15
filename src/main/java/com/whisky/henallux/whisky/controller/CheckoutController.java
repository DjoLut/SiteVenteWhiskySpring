package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.OrderDAO;
import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/checkout")
public class CheckoutController {
    private WhiskyDAO whiskyDAO;
    private Panier panier;
    private OrderDAO orderDAO;

    @Autowired
    public CheckoutController(WhiskyDAO whiskyDAO, Panier panier, OrderDAO orderDAO)
    {
        this.whiskyDAO = whiskyDAO;
        this.panier = panier;
        this.orderDAO = orderDAO;
    }

    @RequestMapping
    public String home(Model model)
    {
        model.addAttribute("panier", panier);
        return "integrated:checkout";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteWhisky(HttpServletRequest request)
    {
        panier.deleteWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))));
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyQuantity(HttpServletRequest request)
    {
        if (request.getParameter("quantity") != "")
            panier.modifyWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/validate")
    public String validatePanier(HttpServletRequest request)
    {
        if(panier.size() != 0)
        {
            if(request.getUserPrincipal() != null)
            {
                orderDAO.addPanier(panier);
                panier.deleteAll();
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
    public String deleteWhisky()
    {
        panier.deleteAll();
        return "redirect:/checkout";
    }

}
