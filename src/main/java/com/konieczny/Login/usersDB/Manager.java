package com.konieczny.Login.usersDB;

import com.konieczny.Login.entities.MyUserDetails;
import com.konieczny.Login.entities.User;
import com.konieczny.Login.security.registrationDataChecking;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Optional;

@Service("userService")
public class Manager implements UserDetailsService {


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
        userRepository.save(userEntity);
    }



}
