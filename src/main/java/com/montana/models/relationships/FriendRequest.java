package com.montana.models.relationships;

import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.CreatedDate;

/**
 * Created by alexto on 20/10/15.
 */

@RelationshipEntity(type = "FRIEND_REQUEST")
public class FriendRequest {

    @GraphId
    private Long id;

    @StartNode
    private User userA;

    @EndNode
    private User userB;

    @CreatedDate
    private Long createdDate;

    public User getUserA() {
        return userA;
    }

    public FriendRequest setUserA(User userA) {
        this.userA = userA;
        return this;
    }

    public User getUserB() {
        return userB;
    }

    public FriendRequest setUserB(User userB) {
        this.userB = userB;
        return this;
    }

    public Long getId() {
        return id;
    }

    public FriendRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public FriendRequest setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
