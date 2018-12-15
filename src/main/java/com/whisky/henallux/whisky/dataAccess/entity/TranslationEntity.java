package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.*;

@Entity(name="TranslationEntity")
@Table(name="translation")
public class TranslationEntity {

    @EmbeddedId
    private TranslationKey id;
    @Column(name="descriptions")
    private String description;

    public TranslationKey getId() { return id; }
    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
    public void setId(TranslationKey id) { this.id = id; }
}
