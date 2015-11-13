package com.montana.services;

import com.montana.apimodels.ProfileViewModel;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;

/**
 * Created by alexto on 10/10/15.
 */

public interface UserService {
    User save(User user);
    User findByUserName(String userName);
    User findByEmail(String email);
    User authenticate(String email, String password);
}
