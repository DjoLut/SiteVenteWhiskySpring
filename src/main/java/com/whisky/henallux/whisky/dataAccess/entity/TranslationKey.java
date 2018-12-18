package com.whisky.henallux.whisky.dataAccess.entity;

import java.io.Serializable;
import java.util.Objects;


public class TranslationKey implements Serializable {
    private WhiskyEntity whiskyEntity;
    private LanguageEntity translations;

    public TranslationKey(){}

    public TranslationKey(WhiskyEntity whiskyId, LanguageEntity languageId){
        this.whiskyEntity = whiskyId;
        this.translations = languageId;
    }

    public LanguageEntity getTranslations() { return translations; }
    public WhiskyEntity getWhiskyEntity() { return whiskyEntity; }

    public void setWhiskyEntity(WhiskyEntity whiskyEntity) { this.whiskyEntity = whiskyEntity; }
    public void setTranslations(LanguageEntity translations) { this.translations = translations; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof TranslationKey)) return false;
        TranslationKey that = (TranslationKey) obj;
        return Objects.equals(getTranslations(), that.getTranslations())&&Objects.equals(getWhiskyEntity(),that.getWhiskyEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWhiskyEntity(), getTranslations());
    }
}
