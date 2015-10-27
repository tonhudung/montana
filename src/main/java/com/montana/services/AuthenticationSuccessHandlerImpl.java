package com.montana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex_to on 27/10/2015.
 */

@Service
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.addCookie(new Cookie("currentUser", securityContextAccessor.getCurrentUserName()));
        httpServletResponse.addCookie(new Cookie("currentUserFirstName", securityContextAccessor.getCurrentUser().getFirstName()));
    }
}
