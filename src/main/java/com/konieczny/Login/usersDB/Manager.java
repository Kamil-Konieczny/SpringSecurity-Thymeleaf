package com.konieczny.Login.usersDB;

import com.konieczny.Login.UserEntities.MyUserDetails;
import com.konieczny.Login.UserEntities.User;
import com.konieczny.Login.profileDB.ProfileService;
import com.konieczny.Login.profileEntity.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service("userService")
public class Manager implements UserDetailsService {


    @Autowired
    private ProfileService profileService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    Repository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(user_email);
       if(user == null)
           {
               throw new UsernameNotFoundException("Invalid username or password.");
           }
        return new MyUserDetails(user);
    }

    public void register(@Valid User user) {
        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setUser_password(passwordEncoder.encode(user.getUser_password()));
        ProfileEntity profileEntity = new ProfileEntity();
        profileService.create(profileEntity);
        userEntity.setProfileEntity(profileEntity);
        userRepository.save(userEntity);
    }
}
