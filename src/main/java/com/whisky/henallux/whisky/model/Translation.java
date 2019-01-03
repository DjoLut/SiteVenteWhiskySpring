package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.LanguageEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;

public class Translation {
    private Integer id;
    private String descriptions;
    private WhiskyEntity whiskyid;
    private LanguageEntity languageid;

    public Translation(){}

    public WhiskyEntity getWhiskyid() { return whiskyid; }
    public String getDescriptions() { return descriptions; }
    public LanguageEntity getLanguageid() { return languageid; }
    public Integer getId() { return id; }

    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
    public void setLanguageid(LanguageEntity languageid) { this.languageid = languageid; }
    public void setWhiskyid(WhiskyEntity whiskyid) { this.whiskyid = whiskyid; }
    public void setId(Integer id) { this.id = id; }

}
