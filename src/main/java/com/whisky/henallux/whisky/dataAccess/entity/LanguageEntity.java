package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="langue")
public class LanguageEntity {
    @Id
    @Column(name="id")
    private String id;
    @OneToMany(mappedBy = "languageid",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TranslationEntity> translations;

    public LanguageEntity(){}

    public Collection<TranslationEntity> getTranslations() { return translations; }
    public void setTranslations(Collection<TranslationEntity> translations) { this.translations = translations; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
