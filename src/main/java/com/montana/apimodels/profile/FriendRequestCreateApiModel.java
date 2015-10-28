package com.montana.apimodels.profile;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 27/10/2015.
 */

public class FriendRequestCreateApiModel {

    @NotBlank
    private String friendToBe;

    public String getFriendToBe() {
        return friendToBe;
    }

    public FriendRequestCreateApiModel setFriendToBe(String friendToBe) {
        this.friendToBe = friendToBe;
        return this;
    }
}
