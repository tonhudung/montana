package com.montana.services;

import com.montana.apimodels.FriendRequestAddModel;
import com.montana.apimodels.FriendshipAddModel;
import com.montana.models.FriendRequestStatus;
import com.montana.models.relationships.FriendRequest;
import com.montana.models.relationships.Friendship;

/**
 * Created by alexto on 27/10/15.
 */

public interface FriendService {

    boolean isFriend(String userA, String userB);

    Friendship findFriendship(String userA, String userB);

    void addFriendship(String friendRequestSender, String friendRequestRecipient);

    void unfriend(String userA, String userB);

    void cancelFriendRequest(String senderUserName, String recipientUserName);

    void addFriendRequest(String senderUserName, String recipientUserName);

    void ignoreFriendRequest(String senderUserName, String recipientUserName);
}
