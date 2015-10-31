package com.montana.apimodels;

import com.montana.models.relationships.FriendRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 30/10/2015.
 */
public class FriendRequestAddModel {

    @NotBlank
    private String recipient;

    public String getRecipient() {
        return recipient;
    }

    public FriendRequestAddModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public static FriendRequestAddModel from(FriendRequest friendRequest) {
        return new FriendRequestAddModel()
                .setRecipient(friendRequest.getRecipient().getUserName());
    }
}
