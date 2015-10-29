package com.montana.apimodels.profile;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 27/10/2015.
 */

public class FriendRequestCreateApiModel {

    @NotBlank
    private String recipient;

    public String getRecipient() {
        return recipient;
    }

    public FriendRequestCreateApiModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }
}
