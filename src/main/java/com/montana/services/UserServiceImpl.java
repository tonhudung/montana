package com.montana.services;

import com.montana.apimodels.FriendshipStatus;
import com.montana.apimodels.ProfileViewModel;
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

    public ProfileViewModel getProfileViewApiModel(String viewee) {

        User user = userRepository.findByUserName(viewee);
        if (user == null)
            throw new NotFoundException();
        String viewer = securityContextAccessor.getCurrentUserName();

        ProfileViewModel profileViewModel = (new ProfileViewModel())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getPhoto().getUrl());

        FriendshipStatus friendshipStatus = null;

        if (!viewer.equalsIgnoreCase(viewee)) {
            Friendship friendship = friendshipRepository.find(viewer, viewee);
            if (friendship != null) {
                friendshipStatus = FriendshipStatus.FRIENDS;
                profileViewModel.setFriendshipId(friendship.getId());
            } else {
                FriendRequest receivedFriendRequest = friendRequestRepository.findBySenderAndRecipient(viewee, viewer);
                if (receivedFriendRequest != null) {
                    switch (receivedFriendRequest.getStatus()) {
                        case SENT:
                            friendshipStatus = FriendshipStatus.RESPONSE_TO_FRIEND_REQUEST;
                            break;
                        case IGNORED:
                        case CANCELLED:
                            friendshipStatus = FriendshipStatus.ADD_FRIEND;
                            break;
                    }
                    profileViewModel.setFriendRequestId(receivedFriendRequest.getId());
                } else {
                    FriendRequest friendRequest = friendRequestRepository.findBySenderAndRecipient(viewer, viewee);
                    if (friendRequest != null) {
                        profileViewModel.setFriendRequestId(friendRequest.getId());
                        switch (friendRequest.getStatus()) {
                            case SENT:
                            case IGNORED:
                                friendshipStatus = FriendshipStatus.FRIEND_REQUEST_SENT;
                                break;
                            case CANCELLED:
                                friendshipStatus = FriendshipStatus.ADD_FRIEND;
                        }
                    } else {
                        friendshipStatus = FriendshipStatus.ADD_FRIEND;
                    }

                }
            }
        }
        profileViewModel.setFriendshipStatus(friendshipStatus);
        return profileViewModel;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void setProfilePicture(Photo photo) {
        //TODO: unset the current profile picture
    }
}
