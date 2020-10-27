package com.konieczny.Login.usersDB;


import com.konieczny.Login.UserEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
