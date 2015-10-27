package com.montana.services;

import com.montana.models.nodes.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by alexto on 18/10/15.
 */
public interface SecurityContextAccessor {
    boolean isAnonymous();

    String getCurrentUserName();

    UserDetails getCurrentUserDetails();

    User getCurrentUser();
}
