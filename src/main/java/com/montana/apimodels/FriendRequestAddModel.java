package com.montana.apimodels;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by alex_to on 27/10/2015.
 */

public class FriendRequestAddModel {

    private Long id;

    @NotBlank
    private String sender;

    @NotBlank
    private String recipient;

    public String getRecipient() {
        return recipient;
    }

    public FriendRequestAddModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public FriendRequestAddModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
