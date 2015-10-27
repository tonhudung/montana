package com.montana.apimodels.profile;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 27/10/2015.
 */

public class FriendRequestCreateApiModel {

    @NotBlank
    private String friendUserName;

    public String getFriendUserName() {
        return friendUserName;
    }

    public FriendRequestCreateApiModel setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
        return this;
    }
}
