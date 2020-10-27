package com.konieczny.Login.UserEntities;

import com.konieczny.Login.profileEntity.ProfileEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String firstname;
    private String lastname;
    private String user_password;
    private boolean active;
    private List<GrantedAuthority> authorities ;
    private String email;
    private User user;
    public MyUserDetails(User user) {
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.user_password = user.getUser_password();
        this.active = user.isUser_active();
        this.authorities = Arrays.stream(user.getUsers_role().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.email = user.getEmail();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }


}
