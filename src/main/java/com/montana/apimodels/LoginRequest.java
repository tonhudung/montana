package com.montana.apimodels;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alext on 11/12/2015.
 */
public class LoginRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }
    public LoginRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
