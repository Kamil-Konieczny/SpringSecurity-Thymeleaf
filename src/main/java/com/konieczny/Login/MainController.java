package com.konieczny.Login;


import com.konieczny.Login.UserEntities.MyUserDetails;
import com.konieczny.Login.profileDB.ProfileService;
import com.konieczny.Login.profileEntity.ProfileEntity;
import com.konieczny.Login.security.registrationDataChecking;
import com.konieczny.Login.usersDB.Manager;
import com.konieczny.Login.usersDB.Repository;
import com.konieczny.Login.UserEntities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    Manager userManager;
    @Autowired
    ProfileService profileService;


    public MainController(Manager userManager) {
        super();
        this.userManager = userManager;
    }

    @GetMapping("/user")
    public String user(final Model model)
    {
        User principal = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        ProfileEntity profileEntity = principal.getProfileEntity();
        String photo = profileEntity.getPhoto();
        model.addAttribute("currentProfile", profileEntity);
        model.addAttribute("photo",photo);
        System.out.println(profileEntity);

        return "home";
    }
    @GetMapping("/login?logout")
    public String logout()
    {
        return "user";
    }
    @GetMapping("/login")
    public String login(final Model model)
    {
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return  "home";
    }

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

    @GetMapping("/home")
    public String home(final Model model)
    {
        return "home";
    }

    @PostMapping("/home")
    public String saveProfile( @RequestParam("file") MultipartFile file,
                               @RequestParam("nickname") String nickname,
                               @RequestParam("aboutMe") String aboutMe,
                               @RequestParam("birthday") String birthday,Model model)
    {

        User principal = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        ProfileEntity profileEntity  = new ProfileEntity();
        profileEntity.setFile(file);
        profileEntity.setNickname(nickname);
        profileEntity.setAboutMe(aboutMe);
        profileEntity.setBirthday(birthday);
        profileService.save(profileEntity,principal.getProfileEntity().getProfile_id());
        return "redirect:/login";
    }

}

