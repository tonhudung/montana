package com.montana.services;

import com.montana.exceptions.ForbiddenException;
import com.montana.exceptions.NotFoundException;
import com.montana.exceptions.UnauthorizedException;
import com.montana.models.FriendRequestStatus;
import com.montana.models.nodes.User;
import com.montana.models.relationships.FriendRequest;
import com.montana.repositories.FriendRequestRepository;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexto on 28/10/15.
 */

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    public boolean isFriend(String userA, String userB) {
        return userRepository.isFriend(userA, userB);
    }

    public FriendRequest findFriendRequest(String sender, String recipient) {
        return null;
    }

    public void sendFriendRequest(String senderUserName, String recipientUserName) {
        if (!securityContextAccessor.getCurrentUserName().equalsIgnoreCase(senderUserName))
            throw new UnauthorizedException();

        User friendToBe = userRepository.findByUserName(recipientUserName);
        if (friendToBe == null)
            throw new NotFoundException();

        User currentUser = userRepository.findByUserName(senderUserName);



        FriendRequest friendRequest = friendRequestRepository
                .findBySenderAndRecipient(senderUserName, recipientUserName);

        if (friendRequest != null) {
            if (friendRequest.getStatus() == FriendRequestStatus.ACCEPTED
                    || friendRequest.getStatus() == FriendRequestStatus.SENT
                    || friendRequest.getStatus() == FriendRequestStatus.IGNORED) {
                throw new ForbiddenException();
            } else {
                // CANCELLED
                friendRequest.setStatus(FriendRequestStatus.SENT);
            }
        } else {
            currentUser.getSentFriendRequests()
                    .add((new FriendRequest())
                            .setSender(currentUser)
                            .setRecipient(friendToBe)
                            .setStatus(FriendRequestStatus.SENT));
        }

        userRepository.save(currentUser);
    }
}
