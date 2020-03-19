package com.controller;


import com.model.User;
import com.security.SecurityService;
import com.service.UserService;
import com.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class RegistrationController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping ("/login")

    public String login (Model model){
        return "login";
    }

    @GetMapping("/registration")
       public String registration(Model model){
           model.addAttribute ("userForm", new User());
           return "registration";
        }

    @PostMapping("/registration")
        public String register (@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
            userValidator.validate(userForm, bindingResult);
            if (bindingResult.hasErrors()){
                return "registration";
            }
            userService.create(userForm);
            securityService.autoLogin(userForm.getUsername() , userForm.getPasswordConfirm());
            return "redirect:/train/list"; ////yet havnt train $)

        }
    @GetMapping ("signin")
    public  String getSignIn(Model model){
        model.addAttribute("userForm", new User());
        return  "signin";
    }

    @PostMapping("/signin")
        public String signIn (@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validateUserAuth(userForm.getUsername(), userForm.getPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            return "signin";
        }
securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
return  "redirect:/train/list"; //yet havnt train $)

    }
    @GetMapping ("/logout")
    public  String logout (Model model){
        return  "redirect:/login";
    }



}
