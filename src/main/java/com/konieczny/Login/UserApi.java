package com.konieczny.Login;


import com.konieczny.Login.security.registrationDataChecking;
import com.konieczny.Login.usersDB.Manager;
import com.konieczny.Login.usersDB.Repository;
import com.konieczny.Login.entities.User;
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
    @Autowired
    Manager userManager;

    public UserApi(Manager userManager) {
        super();
        this.userManager = userManager;
    }

    @GetMapping("/user")
    public String user(final Model model)
    {
        System.out.println(model.getAttribute("email"));
        model.addAttribute("name","User");
        return "mainPage";
    }

    @GetMapping("/login")
    public String login(final Model model)
    {
        return "login";
    }

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
    model.addAttribute("user", new registrationDataChecking());
    return "registration";
}

    @PostMapping("/registration")
    public String userRegistration( @Valid final User user, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", user);
            return "registration";
        }
        userManager.register(user);
        return "redirect:/registration?success";
    }
}

