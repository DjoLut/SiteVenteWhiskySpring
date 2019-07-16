package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.CategorieEntity;
import com.whisky.henallux.whisky.dataAccess.repository.CategorieRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategorieDAO {

    private CategorieRepository categorieRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategorieDAO(CategorieRepository categorieRepository, ProviderConverter providerConverter){
        this.categorieRepository = categorieRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Categorie> getAllCategorie()
    {
        List<CategorieEntity> categorieEntities = categorieRepository.findAll();


        ArrayList<Categorie> categories = new ArrayList<>();
        for(CategorieEntity entity : categorieEntities)
        {
            Categorie categorie = providerConverter.categorieEntityToCategorie(entity);
            categories.add(categorie);
        }
        return categories;
    }
}
