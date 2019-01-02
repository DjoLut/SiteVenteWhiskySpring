package com.whisky.henallux.whisky.model;

import com.whisky.henallux.whisky.dataAccess.entity.LanguageEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;

public class Translation {
    private String description;
    private WhiskyEntity whisky;
    private LanguageEntity language;

    public Translation(){}

    public WhiskyEntity getWhisky() { return whisky; }
    public String getDescription() { return description; }
    public LanguageEntity getLanguage() { return language; }

    public void setDescription(String description) { this.description = description; }
    public void setLanguage(LanguageEntity language) { this.language = language; }
    public void setWhisky(WhiskyEntity whisky) { this.whisky = whisky; }
}
