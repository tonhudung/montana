package com.montana.services;

import com.montana.apimodels.ProfileViewModel;
import com.montana.exceptions.NotFoundException;
import com.montana.exceptions.UnauthorizedException;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexto on 10/10/15.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User authenticate(String email, String password) {
        User user = findByEmail(email);
        if (user == null)
            throw new UnauthorizedException();
        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else
            throw new UnauthorizedException();
    }

    public ProfileViewModel getProfileViewApiModel(String viewer, String viewee) {

        User user = userRepository.findByUserName(viewee);
        if (user == null)
            throw new NotFoundException();

        ProfileViewModel profileViewModel = (new ProfileViewModel())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getUrl());

        return profileViewModel;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
