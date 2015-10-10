package com.montana.services;

import com.montana.models.User;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexto on 10/10/15.
 */

@Service
public class UserServiceIpml implements UserService{

    @Autowired
    private UserRepository userRepository;

    public void AddUser()
    {
        User user = new User();
        user.setEmail("alex.to@outlook.com");
        userRepository.save(user);
    }
}
