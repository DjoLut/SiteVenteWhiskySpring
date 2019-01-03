package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.LanguageDAO;
import com.whisky.henallux.whisky.dataAccess.dao.TranslationDAO;
import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Language;
import com.whisky.henallux.whisky.service.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping(value="/single/{id}")
public class SingleController {
    private WhiskyDAO whiskyDAO;
    private Panier panier;
    private TranslationDAO translationDAO;
    private final MessageSource messageSource;
    private LanguageDAO languageDAO;
    private ProviderConverter providerConverter;

    @Autowired
    public SingleController(WhiskyDAO whiskyDAO, Panier panier, TranslationDAO translationDAO, MessageSource messageSource, LanguageDAO languageDAO, ProviderConverter providerConverter)
    {
        this.whiskyDAO = whiskyDAO;
        this.panier = panier;
        this.translationDAO = translationDAO;
        this.messageSource = messageSource;
        this.languageDAO = languageDAO;
        this.providerConverter = providerConverter;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getWhiskyById(Model model, @PathVariable(value = "id") int id, Locale locale)
    {
        model.addAttribute("whisky", whiskyDAO.getWhiskyById(id));
        String languageid = locale.toString();
        model.addAttribute("translation", translationDAO.getTranslationByWhiskyidAndLanguageid(
                providerConverter.whiskyToWhiskyEntity(whiskyDAO.getWhiskyById(id)),
                providerConverter.languageToLanguageEntity(languageDAO.getLanguageById(languageid))));
        return "integrated:single";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWhisky(HttpServletRequest request)
    {
        panier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/single/{id}";
    }

}