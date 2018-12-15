package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {this.userRepository = userRepository;}

    //METHODE QUI CONNECTE UN USER DEJA ENREGISTRER DANS LA BD


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


    //METHODE QUI ENREGISTRE UN USER DANS LA BD
    /*public User save(User user)
    {
        ;
    }*/

}
