package com.whisky.henallux.whisky.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.springframework.util.StringUtils.isEmpty;

public class User {
    @NotNull
    @NotEmpty
    @Size(min=3,max = 30)
    private String username;
    @NotNull
    @NotEmpty
    @Size(min=3,max = 30)
    private String password;
    private String authorities;
    @NotNull
    @NotEmpty
    @Size(min=3,max = 50)
    private String firstname;
    @NotNull
    @NotEmpty
    @Size(min=3,max = 60)
    private String lastname;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @Size(min=15,max = 200)
    private String adresse;
    private String numberTVA;
    private boolean non_expired;
    private boolean non_locked;
    private boolean credentials_non_expired;
    private boolean enabled;
    @NotNull
    @NotEmpty
    @Size(min=3,max = 30)
    private String confPassword;



    public User(){}

    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setNon_locked(boolean non_locked) { this.non_locked = non_locked; }
    public void setNon_expired(boolean non_expired) { this.non_expired = non_expired; }
    public void setNumberTVA(String numberTVA) { this.numberTVA = numberTVA; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setEmail(String email) { this.email = email; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        String ch = "";
        for(GrantedAuthority authority : authorities) {
            ch += authority.getAuthority() + ",";
        }
        this.authorities = ch;
    }

    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
    public void setCredentials_non_expired(boolean credentials_non_expired) {this.credentials_non_expired = credentials_non_expired; }

    public String getUsername() { return username; }
    public boolean isCredentials_non_expired() { return credentials_non_expired; }
    public boolean isNon_locked() { return non_locked; }
    public boolean isNon_expired() { return non_expired; }
    public String getAdresse() { return adresse; }
    public String getEmail() { return email; }
    public String getLastname() { return lastname;}
    public String getFirstname() { return firstname;}

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

    public boolean isEnabled() { return enabled; }
    public String getNumberTVA() { return numberTVA; }
    public String getPassword() { return password; }
    public String getConfPassword() { return confPassword; }
    public void setConfPassword(String confPassword) { this.confPassword = confPassword; }
}
