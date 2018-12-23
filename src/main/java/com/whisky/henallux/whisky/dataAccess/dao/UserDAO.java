package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDAO(SessionFactory sessionFactory, UserRepository userRepository, ProviderConverter providerConverter, BCryptPasswordEncoder passwordEncoder) {
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

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
        user.setNon_locked(true);
        user.setNon_expired(true);
        user.setEnabled(true);
        user.setCredentials_non_expired(true);
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
    }

    //METHODE QUI ENREGISTRE UN USER DANS LA BD
    public void save(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.userModelToUserEntity(user));
        session.getTransaction().commit();
    }

    public void transactionMethod(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.userModelToUserEntity(user));
        session.getTransaction().commit();
    }

    /*public boolean userExist(String username, String pwd){
        if(userRepository.exists(username))
        {
            System.out.println("fddsfdsf");
            UserEntity userEntity = userRepository.findByUsername(username);
            System.out.println("user : " + username + "\npwd :   " + pwd + "\npwd : " + userEntity.getPassword());
            //if(userEntity.getPassword().equals(pwd))
            if(true)
                return true;
        }
        return false;
    }*/

}
