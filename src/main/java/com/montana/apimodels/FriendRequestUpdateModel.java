package com.montana.apimodels;

import com.montana.models.FriendRequestStatus;

import javax.validation.constraints.NotNull;

/**
 * Created by alex_to on 30/10/2015.
 */
public class FriendRequestUpdateModel {

    @NotNull
    private FriendRequestStatus friendRequestStatus;

    public FriendRequestStatus getFriendRequestStatus() {
        return friendRequestStatus;
    }

    public void setFriendRequestStatus(FriendRequestStatus friendRequestStatus) {
        this.friendRequestStatus = friendRequestStatus;
    }
}
