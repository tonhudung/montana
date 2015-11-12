package com.montana.apimodels;

import com.montana.filters.JwtFilter;
import com.montana.models.nodes.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created by alext on 11/12/2015.
 */
public class LoginResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public static LoginResponse from(User user) {
        return new LoginResponse()
                .setToken(Jwts.builder()
                        .setSubject(user.getEmail())
                        .claim("userName", user.getUserName())
                        .setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, JwtFilter.secretKey).compact());
    }
}
