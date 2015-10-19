package com.montana.services;

import com.montana.models.Photo;
import com.montana.models.User;
import org.springframework.stereotype.Service;

/**
 * Created by alexto on 10/10/15.
 */

public interface UserService {
    User save(User user);

    User findByUserName(String userName);

    void setProfilePicture(Photo photo);
}
