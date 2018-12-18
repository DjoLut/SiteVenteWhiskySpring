package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;
    //private SessionFactory sessionFactory;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

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

    public boolean userExist(String username, String pwd){
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
    }

    //METHODE QUI ENREGISTRE UN USER DANS LA BD
    /*public void save(User user)
    {
        if(userRepository.findOne(user.getUsername())!=null);
            userRepository.save(providerConverter.userModelToUserEntity(user));
    }*/

    //METHODE QUI ENREGISTRE LE NOUVEAU MDP D'UN USER DANS LA BD
    /*public void saveNewPwd(User user){
        userRepository
    }*/

    //METHODE POUR LA SESSION
    /*public void transactionMethod(User user1, User user2)
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(providerConverter.userModelToUserEntity(user1));
        session.update(providerConverter.userModelToUserEntity(user2));
        session.getTransaction().commit();
    }*/

}
