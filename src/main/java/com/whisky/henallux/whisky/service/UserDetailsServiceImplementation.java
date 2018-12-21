package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.management.relation.Role;
import java.util.Arrays;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImplementation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserDetails user = userRepository.findByUsername(username);
        if(user != null)
        {
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }

    /*public User save(UserEntity userEntity){
        User user = new User();
        user.setUsername(userEntity.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        user.setAuthorities("ROLE_USER");
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setEmail(userEntity.getEmail());
        user.setAdresse(userEntity.getAdresse());
        return userRepository.save(user);
    }*/


}
