package ua.kvelinskyi.controllers;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.kvelinskyi.entity.User;

@Component
public class FormValidator implements Validator {


    @Override
    public boolean supports(Class<?> type) {
        // this validator can be applied only to User class
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // the main logic is here
        // actually you have to check in DB that there is no such user
        // and then permit validation
        ValidationUtils.rejectIfEmpty(errors
                // name of field must be equal to class(User) field name
                , "userName"
                // this value is from properties file
                , "error.enterYourName");
        ValidationUtils.rejectIfEmpty(errors, "login", "error.enterYourLogin");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.enterYourPassword");
    }
}