package com.montana.services;

import com.montana.models.nodes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexto on 18/10/15.
 */

@Service
@Transactional
public class SecurityContextAccessorImpl implements SecurityContextAccessor {

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    private UserService userService;

    public boolean isAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    public String getCurrentUserName() {
        return getCurrentUserDetails().getUsername();
    }

    public UserDetails getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    public User getCurrentUser() {
        return userService.findByUserName(getCurrentUserDetails().getUsername());
    }
}
