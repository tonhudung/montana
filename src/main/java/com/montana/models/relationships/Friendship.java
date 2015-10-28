package com.montana.models.relationships;

import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alexto on 28/10/15.
 */

@RelationshipEntity(type = "FRIENDS")
public class Friendship {

    private Long id;

    @StartNode
    private User userA;

    @EndNode
    private User userB;

    @CreatedDate
    @DateLong
    private Date createdDate;

    public Friendship()
    {
        createdDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public Friendship setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUserA() {
        return userA;
    }

    public Friendship setUserA(User userA) {
        this.userA = userA;
        return this;
    }

    public User getUserB() {
        return userB;
    }

    public Friendship setUserB(User userB) {
        this.userB = userB;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Friendship setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
