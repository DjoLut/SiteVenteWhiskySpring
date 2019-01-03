package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private ProviderConverter providerConverter;
    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory, UserRepository userRepository, ProviderConverter providerConverter) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.sessionFactory = sessionFactory;
        this.providerConverter = providerConverter;
    }

    //METHODE POUR AVOIR TOUT LES USERNAMES
    public ArrayList<String> getUsername()
    {
        List<UserEntity> userEntity = userRepository.findAll();
        ArrayList<String> users = new ArrayList<>();
        for(UserEntity entity : userEntity)
        {
            users.add(entity.getUsername());
        }
        return users;
    }

    //METHODE QUI ENREGISTRE UN nouveau USER DANS LA BD
    public void saveNewUser(User user){
        user.setCredentials_non_expired(true);
        user.setEnabled(true);
        user.setNon_expired(true);
        user.setNon_locked(true);
        List<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new SimpleGrantedAuthority("ROLE_USER"));
        user.setAuthorities(collection);
        save(user);
    }

    //METHODE QUI ENREGISTRE UN USER DANS LA BD
    public void save(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
        transactionMethod(user);
    }

    public void transactionMethod(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.userModelToUserEntity(user));
        session.getTransaction().commit();
    }

    //METHODE POUR AVOIR UN WHISKY PAR SON ID
    public User getUserByUsername(String username)
    {
        UserEntity userEntity = userRepository.findByUsername(username);
        return providerConverter.userEntityToUserModel(userEntity);
    }

}
