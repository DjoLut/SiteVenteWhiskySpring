package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.dataAccess.dao.LanguageDAO;
import com.whisky.henallux.whisky.dataAccess.dao.TranslationDAO;
import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import static com.whisky.henallux.whisky.controller.CheckoutController.PANIER;

@Controller
@RequestMapping(value="/single/{id}")
@SessionAttributes({"mainPanier"})
public class SingleController {
    private WhiskyDAO whiskyDAO;
    private TranslationDAO translationDAO;
    private LanguageDAO languageDAO;
    private CategorieDAO categorieDAO;

    @Autowired
    public SingleController(WhiskyDAO whiskyDAO, TranslationDAO translationDAO, LanguageDAO languageDAO, CategorieDAO categorieDAO)
    {
        this.whiskyDAO = whiskyDAO;
        this.translationDAO = translationDAO;
        this.languageDAO = languageDAO;
        this.categorieDAO = categorieDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getWhiskyById(Model model, @PathVariable(value = "id") int id, Locale locale)
    {
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(id));
        String languageid = locale.toString();
        model.addAttribute("translation", translationDAO.getTranslationByWhiskyidAndLanguageid(
                whiskyDAO.getWhiskyById(id),
                languageDAO.getLanguageById(languageid)));
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:single";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWhisky(HttpServletRequest request, @ModelAttribute(value = PANIER) Panier mainPanier)
    {
        if (request.getParameter("quantity") != "")
            mainPanier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/single/{id}";
    }

}