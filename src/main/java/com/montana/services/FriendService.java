package com.montana.services;

import com.montana.apimodels.FriendRequestAddModel;
import com.montana.models.FriendRequestStatus;
import com.montana.models.relationships.FriendRequest;

/**
 * Created by alexto on 27/10/15.
 */

public interface FriendService {

    //region API methods

    void cancelFriendRequest(Long id);

    Long addFriendRequest(String senderUserName, String recipientUserName);

    void updateFriendRequest(Long id, FriendRequestStatus friendRequestStatus);

    FriendRequestAddModel findFriendRequest(Long id);

    //endregion

    boolean isFriend(String userA, String userB);

    FriendRequest findFriendRequest(String sender, String recipient);

}
