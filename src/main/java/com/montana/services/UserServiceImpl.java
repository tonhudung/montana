package com.montana.services;

import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexto on 10/10/15.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void setProfilePicture(Photo photo) {
        //TODO: unset the current profile picture
    }
}
