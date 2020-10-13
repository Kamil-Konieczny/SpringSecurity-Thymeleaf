package com.konieczny.Login.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column
    @NotEmpty(message = "Username can not be empty")
    private String userName;
    @Column
    @NotEmpty(message = "Password can not be empty")
    private String user_password;
    @Column
    private boolean user_active = true;
    @Column
    private String users_role = "ROLE_USER";
    @Column
    @NotEmpty(message = "Email can not be empty")
    private  String user_email;
    public User() {
    }

    public User(int user_id, String userName, String user_password, boolean user_active, String users_roles) {
        this.user_id = user_id;
        this.userName = userName;
        this.user_password = user_password;
        this.user_active = user_active;
        this.users_role = users_roles;
        this.user_email = user_email;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isActive() {
        return user_active;
    }

    public void setActive(boolean active) {
        this.user_active = user_active;
    }

    public String getRoles() {
        return users_role;
    }

    public void setRoles(String roles) {
        this.users_role = users_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_active=" + user_active +
                ", users_roles='" + users_role + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
