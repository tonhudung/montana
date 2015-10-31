package com.montana.apimodels;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by alex_to on 30/10/2015.
 */
public class FriendRequestUpdateModel {

    @NotBlank
    private String user;

    @NotNull
    private FriendRequestStatus friendRequestStatus;

    public FriendRequestStatus getFriendRequestStatus() {
        return friendRequestStatus;
    }

    public void setFriendRequestStatus(FriendRequestStatus friendRequestStatus) {
        this.friendRequestStatus = friendRequestStatus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
