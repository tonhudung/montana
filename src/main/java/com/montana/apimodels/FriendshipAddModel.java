package com.montana.apimodels;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alexto on 31/10/15.
 */
public class FriendshipAddModel {

    @NotBlank
    private String friend;

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
