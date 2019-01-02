package com.whisky.henallux.whisky.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class User {
    private String username;
    private String password;
    private String authorities;
    private String firstname;
    private String lastname;
    private String email;
    private String adresse;
    private String telephone;
    private boolean non_expired;
    private boolean non_locked;
    private boolean credentials_non_expired;
    private boolean enabled;
    private String confPassword;

    public User(){}

    public String getAdresse() { return adresse; }
    public String getEmail() { return email; }
    public String getLastname() { return lastname;}
    public String getFirstname() { return firstname;}
    public String getUsername() { return username; }
    public String getTelephone() { return telephone; }
    public String getPassword() { return password; }
    public String getConfPassword() { return confPassword; }
    public boolean isEnabled() { return enabled; }
    public boolean isCredentials_non_expired() { return credentials_non_expired; }
    public boolean isNon_locked() { return non_locked; }
    public boolean isNon_expired() { return non_expired; }
    public Collection<GrantedAuthority> getAuthorities()
    {
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


    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
    public void setCredentials_non_expired(boolean credentials_non_expired) {this.credentials_non_expired = credentials_non_expired; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setNon_locked(boolean non_locked) { this.non_locked = non_locked; }
    public void setNon_expired(boolean non_expired) { this.non_expired = non_expired; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setEmail(String email) { this.email = email; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setConfPassword(String confPassword) { this.confPassword = confPassword; }

    public void setAuthorities(Collection<GrantedAuthority> authorities)
    {
        String ch = "";
        for(GrantedAuthority authority : authorities) {
            ch += authority.getAuthority() + ",";
        }
        this.authorities = ch;
    }

}
