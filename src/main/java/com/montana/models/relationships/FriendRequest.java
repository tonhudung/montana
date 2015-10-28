package com.montana.models.relationships;

import com.montana.models.FriendRequestStatus;
import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alexto on 20/10/15.
 */

@RelationshipEntity(type = "FRIEND_REQUEST")
public class FriendRequest {

    private Long id;

    @StartNode
    private User sender;

    @EndNode
    private User recipient;

    private FriendRequestStatus status;

    @CreatedDate
    private Date createdDate;

    public FriendRequest()
    {
        this.createdDate = new Date();
    }

    public User getSender() {
        return sender;
    }

    public FriendRequest setSender(User sender) {
        this.sender = sender;
        return this;
    }

    public User getRecipient() {
        return recipient;
    }

    public FriendRequest setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }

    public Long getId() {
        return id;
    }

    public FriendRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public FriendRequest setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public FriendRequestStatus getStatus() {
        return status;
    }

    public FriendRequest setStatus(FriendRequestStatus status) {
        this.status = status;
        return this;
    }
}
