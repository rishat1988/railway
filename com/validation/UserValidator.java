package com.validation;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.xml.bind.ValidationEvent;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports (Class <?> aClass){
        return User.class.equals(aClass);
    }
    @Override
    public  void validate ( Object o, Errors errors){
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length()>32 ){
            errors.rejectValue("Username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername())== null){
            errors.rejectValue("Username" , "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length()>32 ){
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

    public  void validateUserAuth (String username, String password, Errors errors){
        User user = userService.findByUsername(username);
        if (user == null ) {
            errors.rejectValue("username", "SignIn.userForm.username");

        }else if (!userService.checkPassword(user, password)){
            errors.rejectValue("username", "SignIn.userForm.password");
        }
    }

}
