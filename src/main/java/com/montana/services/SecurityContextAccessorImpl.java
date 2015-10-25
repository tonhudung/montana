package com.montana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by alexto on 18/10/15.
 */

@Service
public class SecurityContextAccessorImpl implements SecurityContextAccessor {

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    public boolean isAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
