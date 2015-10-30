package com.montana.apimodels;

import com.montana.models.FriendRequestStatus;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 30/10/2015.
 */
public class FriendRequestAddModel {

    private Long id;

    @NotBlank
    private String sender;

    @NotBlank
    private String recipient;

    private FriendRequestStatus friendRequestStatus;

    public Long getId() {
        return id;
    }

    public FriendRequestAddModel setId(Long id) {
        this.id = id;
        return this;
    }

    public FriendRequestStatus getFriendRequestStatus() {
        return friendRequestStatus;
    }

    public FriendRequestAddModel setFriendRequestStatus(FriendRequestStatus friendRequestStatus) {
        this.friendRequestStatus = friendRequestStatus;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public FriendRequestAddModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public FriendRequestAddModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }
}
