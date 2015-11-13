package com.montana.apimodels;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Alex To on 11/13/2015.
 */
public class User {
    private String userName;
    private String firstName;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public static User from(com.montana.models.nodes.User user) {
        return new User()
                .setUserName(user.getUserName())
                .setFirstName(user.getFirstName());
    }
}
