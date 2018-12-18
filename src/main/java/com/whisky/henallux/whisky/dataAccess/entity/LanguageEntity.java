package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="langue")
public class LanguageEntity {
    @Id
    @Column(name="langueid")
    private String LangueId;
    @OneToMany(mappedBy = "translations",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TranslationEntity> translations;

    public LanguageEntity(){}

    public Set<TranslationEntity> getTranslations() { return translations; }
    public void setTranslations(Set<TranslationEntity> translations) { this.translations = translations; }

    public String getLangueId() { return LangueId; }
    public void setLangueId(String langueId) { LangueId = langueId; }
}
