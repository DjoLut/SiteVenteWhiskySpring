package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TranslationKey implements Serializable {
    @Column(name="whiskyid")
    private Integer whisky;
    @Column(name="languageId")
    private String language;
    public TranslationKey(){}

    public TranslationKey(Integer whisky, String language){
        this.whisky = whisky;
        this.language = language;
    }

    public String getLanguage() { return language; }
    public Integer getWhisky() { return whisky; }

    public void setWhisky(Integer whisky) { this.whisky = whisky; }
    public void setLanguage(String language) { this.language = language; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof TranslationKey)) return false;
        TranslationKey that = (TranslationKey) obj;
        return Objects.equals(getLanguage(), that.getLanguage())&&Objects.equals(getWhisky(),that.getWhisky());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWhisky(),getLanguage());
    }
}
