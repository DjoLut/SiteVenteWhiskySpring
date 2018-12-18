package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="categorie")
public class CategorieEntity {
    @Id
    @Column(name="nom")
    private String nom;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<WhiskyEntity> whiskyEntity;

    public CategorieEntity(){}

    public void setWhiskyEntity(Set<WhiskyEntity> whiskyEntity) {
        this.whiskyEntity = whiskyEntity;
    }

    public Set<WhiskyEntity> getWhiskyEntity() {
        return whiskyEntity;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }
}
