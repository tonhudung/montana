package com.montana.services;

import com.montana.apimodels.profile.ProfileViewApiModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import com.montana.models.relationships.FriendRequest;
import com.montana.repositories.FriendRequestRepository;
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

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public ProfileViewApiModel getProfileViewApiModel(String viewer, String viewee) {

        User user = userRepository.findByUserName(viewee);
        if (user == null)
            throw new NotFoundException();

        String currentUserName = securityContextAccessor.getCurrentUserName();

        FriendRequest friendRequest = friendRequestRepository.findBySenderAndRecipient(viewer, viewee);


        return (new ProfileViewApiModel())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getPhoto().getUrl());
                //.setIsFriend(friendService.isFriend(currentUserName, userName));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void setProfilePicture(Photo photo) {
        //TODO: unset the current profile picture
    }
}
