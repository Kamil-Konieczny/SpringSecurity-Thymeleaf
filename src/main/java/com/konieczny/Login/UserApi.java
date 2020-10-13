package com.konieczny.Login;


import com.konieczny.Login.usersDB.Repository;
import com.konieczny.Login.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserApi {
    @Autowired
    Repository userRepository;


    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("name","User");
        return "mainPage";
    }

    @GetMapping("/login")
    public String login()
    { return "login"; }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("name","Admin");
        return  "mainPage";
    }

//    @GetMapping("/registration")
//    public String registration(Model model)
//    {
//        model.addAttribute("user", new User());
//        return "registration";
//    }
//    @PostMapping("/add-user")
//    public String addUser(@ModelAttribute User user)
//    {
//        userRepository.save(user);
//        return "registration";
//    }
@GetMapping("/registration")
public String register(final Model model){
    model.addAttribute("user", new User());
    return "registration";
}

    @PostMapping("/registration")
    public String userRegistration(final @Valid User user, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", user);
            return "registration";
        }

        return "/login";
    }
}

