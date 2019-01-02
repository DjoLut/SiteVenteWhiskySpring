package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation")
public class TranslationEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "whiskyid", referencedColumnName = "id")
    private WhiskyEntity whiskyid;
    @ManyToOne
    @JoinColumn(name = "languageid", referencedColumnName = "languageid")
    private LanguageEntity translations;

    @Column(name="descriptions")
    private String description;

    public TranslationEntity(){}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LanguageEntity getTranslations() { return translations; }
    public WhiskyEntity getWhiskyid() { return whiskyid; }

    public void setWhiskyid(WhiskyEntity whiskyid) { this.whiskyid = whiskyid; }
    public void setTranslations(LanguageEntity translations) { this.translations = translations; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
