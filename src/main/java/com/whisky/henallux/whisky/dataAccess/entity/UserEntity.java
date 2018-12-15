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
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="adresse")
    private String adresse;
    @Column(name="numberTVA")
    private String numberTVA;
    @Column(name="non_expired")
    private boolean non_expired;
    @Column(name="non_locked")
    private boolean non_locked;
    @Column(name="credentials_non_expired")
    private boolean credentials_non_expired;
    @Column(name="enabled")
    private boolean enabled;

    public UserEntity(){}

    public String getUsername() { return username; }
    public String getPwd(){ return this.pwd; }
    public String getAuthorities() { return authorities; }
    public String getFirstName() { return firstName; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getAdresse() { return adresse; }
    public String getNumberTVA() { return numberTVA; }
    public boolean isNon_expired() { return non_expired; }
    public boolean isNon_locked() { return non_locked; }
    public boolean isCredentials_non_expired() { return credentials_non_expired; }
    public boolean isEnabled() { return enabled; }

    public void setUsername(String username) { this.username = username; }
    public void setPwd(String pwd) { this.pwd = pwd; }
    public void setAuthorities(String authorities) { this.authorities = authorities; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setNumberTVA(String numberTVA) { this.numberTVA = numberTVA; }
    public void setNon_expired(boolean non_expired) { this.non_expired = non_expired; }
    public void setNon_locked(boolean non_locked) { this.non_locked = non_locked; }
    public void setCredentials_non_expired(boolean credentials_non_expired) { this.credentials_non_expired = credentials_non_expired; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
