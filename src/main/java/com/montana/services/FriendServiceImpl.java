package com.montana.services;

import com.montana.exceptions.ForbiddenException;
import com.montana.exceptions.NotFoundException;
import com.montana.models.FriendRequestStatus;
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
 * Created by alexto on 28/10/15.
 */

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;

    public boolean isFriend(String userA, String userB) {
        return userRepository.isFriend(userA, userB);
    }

    public Friendship findFriendship(String userA, String userB) {
        return null;
    }

    public void addFriendship(String friendRequestSender, String friendRequestRecipient) {
        Friendship existingFriendship = friendshipRepository.find(friendRequestSender, friendRequestRecipient);
        if (existingFriendship != null)
            throw new ForbiddenException();

        // Only allow to add a friendship if there is an existing friend request from friend request sender
        FriendRequest friendRequest = friendRequestRepository.find(friendRequestSender, friendRequestRecipient);
        if (friendRequest == null || friendRequest.getStatus() != FriendRequestStatus.SENT)
            throw new ForbiddenException();

        User a = userRepository.findByUserName(friendRequestSender);
        User b = userRepository.findByUserName(friendRequestRecipient);
        friendRequestRepository.delete(friendRequest);
        a.getFriendships().add((new Friendship())
                .setUserA(a)
                .setUserB(b));
        userRepository.save(a);
    }

    public void unfriend(String userA, String userB) {
        Friendship friendship = friendshipRepository.find(userA, userB);
        if (friendship == null)
            throw new ForbiddenException();
        friendshipRepository.delete(friendship);
    }

    public void cancelFriendRequest(String senderUserName, String recipientUserName) {
        FriendRequest friendRequest = friendRequestRepository.findBySenderAndRecipient(senderUserName, recipientUserName);
        if (friendRequest == null)
            throw new NotFoundException();

        FriendRequestStatus status = friendRequest.getStatus();

        switch (status) {
            case IGNORED:
                // Do nothing, this request has been ignored by recipient
                // The status IGNORED is kept so that the sender won't be able to spam Friend Request
                break;
            case SENT:
                friendRequestRepository.delete(friendRequest);
                break;
            default:
                throw new ForbiddenException();
        }

    }

    public void addFriendRequest(String senderUserName, String recipientUserName) {
        if (senderUserName.equals(recipientUserName))
            throw new ForbiddenException();

        User recipient = userRepository.findByUserName(recipientUserName);
        if (recipient == null)
            throw new NotFoundException();

        Friendship existingFriendship = friendshipRepository.find(senderUserName, recipientUserName);
        if (existingFriendship != null)
            throw new ForbiddenException();

        FriendRequest friendRequest = friendRequestRepository.find(senderUserName, recipientUserName);

        User sender = userRepository.findByUserName(senderUserName);

        if (friendRequest != null) {
            boolean isOutgoingRequest = friendRequest.getSender().getUserName().equalsIgnoreCase(senderUserName);
            if (isOutgoingRequest) {
                switch (friendRequest.getStatus()) {
                    case SENT:
                        throw new ForbiddenException();
                    case IGNORED:
                        // Do nothing, the recipient has ignored friend request from the sender so don't send again.
                        break;
                    default:
                        throw new ForbiddenException();
                }
            } else {
                // if the recipient has sent a friend request before,
                // and if the sender has ignore that previous request, then we have to delete that request
                // and make a new request from the send

                switch (friendRequest.getStatus()) {
                    case IGNORED:
                        friendRequestRepository.delete(friendRequest);
                        FriendRequest newFriendRequest = (new FriendRequest())
                                .setSender(sender)
                                .setRecipient(recipient)
                                .setStatus(FriendRequestStatus.SENT);
                        sender.getFriendRequests().add(newFriendRequest);
                        break;
                    default:
                        throw new ForbiddenException();
                }
            }
        } else {
            FriendRequest newFriendRequest = (new FriendRequest())
                    .setSender(sender)
                    .setRecipient(recipient)
                    .setStatus(FriendRequestStatus.SENT);
            sender.getFriendRequests().add(newFriendRequest);
        }
        userRepository.save(sender);
    }

    public void ignoreFriendRequest(String senderUserName, String recipientUserName) {
        FriendRequest friendRequest = friendRequestRepository.findBySenderAndRecipient(senderUserName, recipientUserName);

        if (friendRequest == null)
            throw new NotFoundException();

        FriendRequestStatus currentStatus = friendRequest.getStatus();
        User sender = userRepository.findByUserName(senderUserName);
        switch (currentStatus) {
            case SENT:
                friendRequest.setStatus(FriendRequestStatus.IGNORED);
                userRepository.save(sender);
                break;
            default:
                throw new ForbiddenException();
        }
    }
}
