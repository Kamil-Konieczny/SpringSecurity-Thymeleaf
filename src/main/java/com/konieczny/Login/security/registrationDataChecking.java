package com.konieczny.Login.security;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class registrationDataChecking implements Serializable {


    @NotEmpty(message = "Username can not be empty")
    private String firstName;
    @NotEmpty(message = "Username can not be empty")
    private String lastName;
    @NotEmpty(message = "Password can not be empty")
    private String user_password;
    @NotEmpty(message = "Email can not be empty")
    private  String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
