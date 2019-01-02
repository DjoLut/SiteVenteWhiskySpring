package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="langue")
public class LanguageEntity {
    @Id
    @Column(name="languageid")
    private String languageid;
    @OneToMany(mappedBy = "translations",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TranslationEntity> translations;

    public LanguageEntity(){}

    public Collection<TranslationEntity> getTranslations() { return translations; }
    public void setTranslations(Collection<TranslationEntity> translations) { this.translations = translations; }

    public String getLanguageid() { return languageid; }
    public void setLanguageid(String languageid) { languageid = languageid; }
}
