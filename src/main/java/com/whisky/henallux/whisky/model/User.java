package com.whisky.henallux.whisky.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.springframework.util.StringUtils.isEmpty;

public class User {
    @NotEmpty
    @Size(min = 3, max = 30)
    private String username;

    @NotEmpty
    @Size(min = 3, max = 30)
    private String password;

    private String authorities;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String firstname;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String lastname;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, max = 200)
    private String adresse;

    @NotEmpty
    @Pattern(regexp = "(0|((00|\\\\+)[0-9]{2,3}))?(\\\\/|\\\\.|\\\\-|\\\\ )?[0-9]{2,3}(\\\\/|\\\\.|\\\\-|\\\\ )?((([0-9]{2}(\\\\/|\\\\.|\\\\-|\\\\ )?){3,4})|(([0-9]{3}(\\\\/|\\\\.|\\\\-|\\\\ )?){2,3}))")
    private String telephone;

    private Boolean non_expired;
    private Boolean non_locked;
    private Boolean credentials_non_expired;
    private Boolean enabled;

    @NotEmpty
    @Size(min = 3, max = 30)
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
    public Boolean isEnabled() { return enabled; }
    public Boolean isCredentials_non_expired() { return credentials_non_expired; }
    public Boolean isNon_locked() { return non_locked; }
    public Boolean isNon_expired() { return non_expired; }
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
    public void setCredentials_non_expired(Boolean credentials_non_expired) {this.credentials_non_expired = credentials_non_expired; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public void setNon_locked(Boolean non_locked) { this.non_locked = non_locked; }
    public void setNon_expired(Boolean non_expired) { this.non_expired = non_expired; }
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
