package com.konieczny.Login.usersDB;


import com.konieczny.Login.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
