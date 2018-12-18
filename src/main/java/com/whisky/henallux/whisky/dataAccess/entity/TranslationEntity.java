package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation")
@IdClass(TranslationKey.class)
public class TranslationEntity implements java.io.Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "whiskyEntity")
    private WhiskyEntity whiskyEntity;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "translations")
    private LanguageEntity translations;

    @Column(name="descriptions")
    private String description;

    public TranslationEntity(){}


    public LanguageEntity getTranslations() { return translations; }
    public WhiskyEntity getWhiskyEntity() { return whiskyEntity; }

    public void setWhiskyEntity(WhiskyEntity whiskyEntity) { this.whiskyEntity = whiskyEntity; }
    public void setTranslations(LanguageEntity translations) { this.translations = translations; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
