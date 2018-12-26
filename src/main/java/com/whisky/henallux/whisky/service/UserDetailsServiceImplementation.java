package com.whisky.henallux.whisky.service;

import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return null;
    }

    public boolean UserExist(String username){
        return userRepository.findByUsername(username)!=null;
    }

    public boolean EmailExist(String email){
        return userRepository.findByEmail(email) != null;
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
        UserDetails user = userRepository.findByEmail(email);
        if(user!=null)
            return user;
        return null;
    }
}
