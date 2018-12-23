package com.whisky.henallux.whisky.Validator;

import com.whisky.henallux.whisky.model.User;
import com.whisky.henallux.whisky.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sun.misc.Regexp;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserDetailsServiceImplementation userService;

    public boolean supports(Class clazz){
        return clazz.equals(User.class);
    }

    public void validate(Object obj, Errors errors){
        User user = (User)obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname", "username");
        if(user.getUsername().length()<3 || user.getUsername().length()>30)
            errors.rejectValue("username","Size.username");
        if(userService.loadUserByUsername(user.getUsername())!=null)
            errors.rejectValue("username", "Duplicate.username");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(user.getPassword().length()<3 || user.getPassword().length()>30)
            errors.rejectValue("password", "Size.password");
        if(!user.getPassword().equals(user.getConfPassword()))
            errors.rejectValue("confPassword", "Diff.confPassword");

        ValidationUtils.rejectIfEmpty(errors,"firstname", "fistname");
        if(user.getFirstname().length()<3 || user.getFirstname().length()>50)
            errors.rejectValue("firstname", "Size.firstname");

        ValidationUtils.rejectIfEmpty(errors,"lastname","lastname");
        if(user.getLastname().length()<3 || user.getLastname().length() > 60)
            errors.rejectValue("lastname", "Size.lastname");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email");
        if(user.getEmail().equals(new Regexp("^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")))
            errors.rejectValue("email", "Invalid.email");

        ValidationUtils.rejectIfEmpty(errors,"adresse","adresse");
        if(user.getAdresse().length()<15 || user.getAdresse().length() >200)
            errors.rejectValue("adresse", "Size.adresse");

    }
}
