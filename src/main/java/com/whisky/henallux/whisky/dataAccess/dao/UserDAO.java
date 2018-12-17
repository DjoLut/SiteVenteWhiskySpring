package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.repository.UserRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;
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
            UserEntity userEntity = userRepository.findOne(username);
            System.out.println("user : " + username + "\neferfe :   " + pwd + "\n kjguy : " + userEntity.getPassword());
            //if(userEntity.getPwd().equals(pwd))
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

}
