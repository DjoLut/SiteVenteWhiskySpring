package com.whisky.henallux.whisky.dataAccess.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.springframework.util.StringUtils.isEmpty;

@Entity
@Table(name="PERSISTABLE_USER")
public class UserEntity implements UserDetails {
    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "AUTHORITIES")
    private String authorities;
    @Column(name="FIRSTNAME")
    private String firstname;
    @Column(name="LASTNAME")
    private String lastname;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ADRESSE")
    private String adresse;
    @Column(name="NUMBERTVA")
    private String numberTVA;
    @Column(name = "NON_EXPIRED")
    private Boolean accountNonExpired;
    @Column(name = "NON_LOCKED")
    private Boolean accountNonLocked;
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private Boolean credentialsNonExpired;
    @Column(name = "ENABLED")
    private Boolean enabled;
    @OneToMany(mappedBy = "utilisateur")
    private Collection<OrderEntity> orders;
    @Transient
    private String confPassword;

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getNumberTVA() {
        return numberTVA;
    }
    public String getEmail() {
        return email;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if(!isEmpty(authorities)) {
            String[] authoritiesAsArray = authorities.split(",");

            for(String authority : authoritiesAsArray) {
                if(!isEmpty(authority)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }
    public Collection<OrderEntity> getOrders() { return orders; }
    public String getConfPassword() {
        return confPassword;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = true;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = true;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) { this.credentialsNonExpired = true; }
    public void setEnabled(Boolean enabled) {
        this.enabled = true;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setNumberTVA(String numberTVA) {
        this.numberTVA = numberTVA;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) { this.password = password; }
    public void setAuthorities(Collection<GrantedAuthority> authorities)
    {
        String ch = "";
        for(GrantedAuthority authority : authorities) {
            ch += authority.getAuthority() + ",";
        }
        this.authorities = ch;
    }
    public void setOrders(Collection<OrderEntity> orders) { this.orders = orders; }
    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

}
