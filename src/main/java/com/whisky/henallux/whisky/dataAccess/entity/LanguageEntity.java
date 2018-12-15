package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="langue")
public class LanguageEntity {
    @Id
    @Column(name="langueid")
    private String LangueId;

    public LanguageEntity(){}

    public String getLangueId() { return LangueId; }

    public void setLangueId(String langueId) { LangueId = langueId; }
}
