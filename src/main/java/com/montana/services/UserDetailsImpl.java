package com.montana.services;

import com.montana.models.nodes.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by alext on 10/10/2015.
 */

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public static UserDetails from(User user) {
        return (new UserDetailsImpl())
                .setUsername(user.getUserName())
                .setPassword(user.getPassword())
                .setAccountNonExpired(user.isAccountNonExpired())
                .setAccountNonLocked(user.isAccountNonLocked())
                .setCredentialsNonExpired(user.isCredentialsNonExpired())
                .setEnabled(user.isEnabled());

    }

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    public String getPassword() {
        return password;
    }

    private UserDetailsImpl setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    private UserDetailsImpl setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    private UserDetailsImpl setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    private UserDetailsImpl setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    private UserDetailsImpl setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getUsername() {
        return username;
    }

    private UserDetailsImpl setUsername(String username) {
        this.username = username;
        return this;
    }
}
