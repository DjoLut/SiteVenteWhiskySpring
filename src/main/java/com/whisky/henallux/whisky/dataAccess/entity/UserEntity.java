package com.whisky.henallux.whisky.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class UserEntity {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="pwd")
    private String pwd;

    @Column(name="authorities")
    private String authorities;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="email")
    private String email;

    @Column(name="adresse")
    private String adresse;

    @Column(name="numberTVA")
    private String numberTVA;

    @Column(name="non_expired")
    private Boolean non_expired;

    @Column(name="non_locked")
    private Boolean non_locked;

    @Column(name="credentials_non_expired")
    private Boolean credentials_non_expired;

    @Column(name="enabled")
    private Boolean enabled;

    public UserEntity() {;}

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public String getAuthorities() {
        return authorities;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNumberTVA() {
        return numberTVA;
    }

    public Boolean getNon_expired() {
        return non_expired;
    }

    public Boolean getNon_locked() {
        return non_locked;
    }

    public Boolean getCredentials_non_expired() {
        return credentials_non_expired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumberTVA(String numberTVA) {
        this.numberTVA = numberTVA;
    }

    public void setNon_expired(Boolean non_expired) {
        this.non_expired = non_expired;
    }

    public void setNon_locked(Boolean non_locked) {
        this.non_locked = non_locked;
    }

    public void setCredentials_non_expired(Boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
