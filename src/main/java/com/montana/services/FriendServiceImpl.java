package com.montana.services;

import com.montana.exceptions.ForbiddenException;
import com.montana.exceptions.NotFoundException;
import com.montana.exceptions.UnauthorizedException;
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
    private SecurityContextAccessor securityContextAccessor;

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;

    public boolean isFriend(String userA, String userB) {
        return userRepository.isFriend(userA, userB);
    }

    public FriendRequest findFriendRequest(String sender, String recipient) {
        return friendRequestRepository.findBySenderAndRecipient(sender, recipient);
    }

    public void cancelFriendRequest(Long id) {
        FriendRequest friendRequest = friendRequestRepository.findById(id);
        if (friendRequest == null)
            throw new NotFoundException();

        String currentUser = securityContextAccessor.getCurrentUserName();

        if (!currentUser.equalsIgnoreCase(friendRequest.getSender().getUserName()))
            throw new ForbiddenException();

        FriendRequestStatus status = friendRequest.getStatus();

        switch (status) {
            case IGNORED:
                // Do nothing, this request has been ignored by recipient
                break;
            case SENT:
                friendRequest.setStatus(FriendRequestStatus.CANCELLED);
                break;
            default:
                throw new ForbiddenException();
        }

        userRepository.save(friendRequest.getSender());
    }

    public Long addFriendRequest(String senderUserName, String recipientUserName) {

        if (senderUserName.equals(recipientUserName))
            throw new ForbiddenException();

        if (!securityContextAccessor.getCurrentUserName().equalsIgnoreCase(senderUserName))
            throw new UnauthorizedException();

        User recipient = userRepository.findByUserName(recipientUserName);
        if (recipient == null)
            throw new NotFoundException();

        Friendship existingFriendship = friendshipRepository.find(senderUserName, recipientUserName);
        if (existingFriendship != null)
            throw new ForbiddenException();

        FriendRequest existingFriendRequest = friendRequestRepository
                .findBySenderAndRecipient(senderUserName, recipientUserName);

        User sender = userRepository.findByUserName(senderUserName);
        Long id;
        if (existingFriendRequest != null) {
            switch (existingFriendRequest.getStatus()) {
                case ACCEPTED:
                case SENT:
                case IGNORED:
                    throw new ForbiddenException();
                case CANCELLED:
                    existingFriendRequest.setStatus(FriendRequestStatus.SENT);
            }
            id = existingFriendRequest.getId();
        } else {
            FriendRequest receivedRequest = friendRequestRepository.findBySenderAndRecipient(recipientUserName, senderUserName);
            if (receivedRequest != null) {
                switch (receivedRequest.getStatus()) {
                    case SENT:
                    case IGNORED:
                        receivedRequest.setStatus(FriendRequestStatus.ACCEPTED);
                        friendRequestRepository.save(receivedRequest);
                }
            }

            FriendRequest newFriendRequest = (new FriendRequest())
                    .setSender(sender)
                    .setRecipient(recipient)
                    .setStatus(FriendRequestStatus.SENT);

            sender.getSentFriendRequests().add(newFriendRequest);
            id = newFriendRequest.getId();
        }
        userRepository.save(sender);
        return id;
    }
}
