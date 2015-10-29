package com.montana.services;

import com.montana.apimodels.profile.FriendButton;
import com.montana.apimodels.profile.ProfileViewApiModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import com.montana.models.relationships.FriendRequest;
import com.montana.models.relationships.Friendship;
import com.montana.repositories.FriendRequestRepository;
import com.montana.repositories.FriendshipRepository;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public ProfileViewApiModel getProfileViewApiModel(String viewee) {

        User user = userRepository.findByUserName(viewee);
        if (user == null)
            throw new NotFoundException();
        String viewer = securityContextAccessor.getCurrentUserName();

        FriendButton friendButton = null;
        if (!viewer.equalsIgnoreCase(viewee)) {
            Friendship friendship = friendshipRepository.find(viewer, viewee);
            if (friendship != null) {
                friendButton = FriendButton.FRIENDS;
            } else {
                FriendRequest receivedFriendRequest = friendRequestRepository.findBySenderAndRecipient(viewee, viewer);
                if (receivedFriendRequest != null) {
                    switch (receivedFriendRequest.getStatus()) {
                        case SENT:
                            friendButton = FriendButton.RESPONSE_TO_FRIEND_REQUEST;
                            break;
                        case IGNORED:
                        case CANCELLED:
                            friendButton = FriendButton.ADD_FRIEND;
                            break;
                    }
                } else {
                    FriendRequest friendRequest = friendRequestRepository.findBySenderAndRecipient(viewer, viewee);
                    if (friendRequest != null) {
                        switch (friendRequest.getStatus()) {
                            case SENT:
                            case IGNORED:
                                friendButton = FriendButton.FRIEND_REQUEST_SENT;
                                break;
                            case CANCELLED:
                                friendButton = FriendButton.ADD_FRIEND;
                        }
                    } else {
                        friendButton = FriendButton.ADD_FRIEND;
                    }
                }
            }
        }

        return (new ProfileViewApiModel())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getPhoto().getUrl())
                .setFriendButton(friendButton);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void setProfilePicture(Photo photo) {
        //TODO: unset the current profile picture
    }
}
