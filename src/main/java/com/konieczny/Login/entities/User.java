package com.konieczny.Login.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column
    @NotEmpty(message = "Username can not be empty")
    private String firstName;
    @Column
    @NotEmpty(message = "Username can not be empty")
    private String lastName;
    @Column
    @NotEmpty(message = "Password can not be empty")
    private String user_password;
    @Column
    private boolean user_active = true;
    @Column
    private String users_role = "ROLE_USER";
    @Column
    @NotEmpty(message = "Email can not be empty")
    private  String email;
    public User() {
    }

    public User(@NotEmpty(message = "Username can not be empty") String firstName, @NotEmpty(message = "Username can not be empty") String lastName, @NotEmpty(message = "Password can not be empty") String user_password, String users_role, @NotEmpty(message = "Email can not be empty") String email) {
       super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.user_password = user_password;
        this.users_role = users_role;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isUser_active() {
        return user_active;
    }

    public void setUser_active(boolean user_active) {
        this.user_active = user_active;
    }

    public String getUsers_role() {
        return users_role;
    }

    public void setUsers_role(String users_role) {
        this.users_role = users_role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
