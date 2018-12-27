package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="categorie")
public class CategorieEntity {
    @Id
    @Column(name="nom")
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private Collection<WhiskyEntity> whiskyEntity;

    public CategorieEntity(){}

    public void setWhiskyEntity(Collection<WhiskyEntity> whiskyEntity) {
        this.whiskyEntity = whiskyEntity;
    }

    public Collection<WhiskyEntity> getWhiskyEntity() {
        return whiskyEntity;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }
}
