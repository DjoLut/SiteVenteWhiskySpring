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
    @JoinColumn(name = "languageid", referencedColumnName = "id")
    private LanguageEntity languageid;

    @Column(name="descriptions")
    private String descriptions;

    public TranslationEntity(){}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LanguageEntity getLanguageid() { return languageid; }
    public WhiskyEntity getWhiskyid() { return whiskyid; }

    public void setWhiskyid(WhiskyEntity whiskyid) { this.whiskyid = whiskyid; }
    public void setLanguageid(LanguageEntity languageid) { this.languageid = languageid; }

    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
}
