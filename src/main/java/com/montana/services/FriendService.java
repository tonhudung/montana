package com.montana.services;

import com.montana.models.relationships.FriendRequest;

/**
 * Created by alexto on 27/10/15.
 */

public interface FriendService {

    boolean isFriend(String userA, String userB);

    FriendRequest findFriendRequest(String sender, String recipient);

    void cancelFriendRequest(String sender, String recipient);

    void sendFriendRequest(String senderUserName, String recipientUserName);
}
