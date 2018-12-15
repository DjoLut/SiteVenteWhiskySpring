package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class CategorieEntity {
    @Id
    @Column(name="nom")
    private String nom;

    public CategorieEntity(){}

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }
}
