package com.whisky.henallux.whisky.dataAccess.util;

import com.whisky.henallux.whisky.dataAccess.entity.CommandLineEntity;
import com.whisky.henallux.whisky.dataAccess.entity.OrderEntity;
import com.whisky.henallux.whisky.dataAccess.entity.UserEntity;
import com.whisky.henallux.whisky.dataAccess.entity.WhiskyEntity;
import com.whisky.henallux.whisky.model.CommandLine;
import com.whisky.henallux.whisky.model.Order;
import com.whisky.henallux.whisky.model.User;
import com.whisky.henallux.whisky.model.Whisky;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    //METHODE POUR CONVERTIR UN OBJET DE TYPE USERENTITY EN OBJET DE TYPE USER
    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAdresse(user.getAdresse());
        userEntity.setAuthorities(user.getAuthorities());
        userEntity.setCredentialsNonExpired(user.isCredentials_non_expired());
        userEntity.setEmail(user.getEmail());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setLastname(user.getLastname());
        userEntity.setAccountNonExpired(user.isNon_expired());
        userEntity.setAccountNonLocked(user.isNon_locked());
        userEntity.setNumberTVA(user.getNumberTVA());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstname(user.getFirstname());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity)
    {
        User user = new User();
        user.setAdresse(userEntity.getAdresse());
        user.setAuthorities(userEntity.getAuthorities());
        user.setCredentials_non_expired(userEntity.isCredentialsNonExpired());
        user.setEmail(userEntity.getEmail());
        user.setEnabled(userEntity.getEnabled());
        user.setFirstname(userEntity.getLastname());
        user.setLastname(userEntity.getLastname());
        user.setNon_expired(userEntity.getAccountNonExpired());
        user.setNon_locked(userEntity.getAccountNonLocked());
        user.setNumberTVA(userEntity.getNumberTVA());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setConfPassword(userEntity.getPassword());
        return user;
    }
    /*public UserEntity userModelToUserEntity(User user) { return mapper.map(user, UserEntity.class); }
    public User userEntityToUserModel(UserEntity userEntity) { return  mapper.map(userEntity, User.class); }*/

    public WhiskyEntity whiskyToWhiskyEntity(Whisky whisky)
    {
        return mapper.map(whisky, WhiskyEntity.class);
    }

    public Whisky whiskyEntityToWhisky(WhiskyEntity whiskyEntity)
    {
        return mapper.map(whiskyEntity, Whisky.class);
    }


    public CommandLineEntity commandLineToCommandLineEntity(CommandLine commandLine) { return mapper.map(commandLine, CommandLineEntity.class); }

    public CommandLine commandLineEntityToCommandLine(CommandLineEntity commandLineEntity) { return mapper.map(commandLineEntity, CommandLine.class); }


    public OrderEntity orderToOrderEntity(Order order) { return mapper.map(order, OrderEntity.class); }

    public Order orderEntityToOrder(OrderEntity orderEntity) { return mapper.map(orderEntity, Order.class); }


}
