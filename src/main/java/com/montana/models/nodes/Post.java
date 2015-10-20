package com.montana.models.nodes;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.CreatedDate;

/**
 * Created by alex_to on 20/10/2015.
 */

@NodeEntity
public class Post {
    @GraphId
    private Long id;

    private String message;

    @CreatedDate
    private Long createdDate;

    @Relationship(type = "HAS_LINK")
    private Link link;

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }


    public Long getCreatedDate() {
        return createdDate;
    }

    public Post setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Post setMessage(String message) {
        this.message = message;
        return this;
    }

    public Link getLink() {
        return link;
    }

    public Post setLink(Link link) {
        this.link = link;
        return this;
    }
}
