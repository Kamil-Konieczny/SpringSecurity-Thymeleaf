package com.konieczny.Login.usersDB;

import com.konieczny.Login.models.MyUserDetails;
import com.konieczny.Login.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Manager implements UserDetailsService {


    @Autowired
    Repository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(user_name);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + user_name));
        return user.map(MyUserDetails::new).get();
    }

}
