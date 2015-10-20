package com.montana.models.nodes;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by alext on 10/11/2015.
 */

@NodeEntity
public class Photo {

    @GraphId
    private Long id;

    private String url;

    @Relationship(type = "UPLOADED", direction = Relationship.INCOMING)
    private User user;

    public Long getId() {
        return id;
    }

    public Photo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Photo setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Photo setUser(User user) {
        this.user = user;
        return this;
    }
}
