package com.montana.models.relationships;

import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by alext on 10/11/2015.
 */

@RelationshipEntity(type = "HAS_PROFILE_PICTURE")
public class HasProfilePicture {

    @GraphId
    private Long id;
    @StartNode
    private Photo photo;
    @EndNode
    private User user;

    private boolean current;

    public Long getId() {
        return id;
    }

    public HasProfilePicture setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public HasProfilePicture setUser(User user) {
        this.user = user;
        return this;
    }

    public Photo getPhoto() {
        return photo;
    }

    public HasProfilePicture setPhoto(Photo photo) {
        this.photo = photo;
        return this;
    }

    public boolean isCurrent() {
        return current;
    }

    public HasProfilePicture setCurrent(boolean current) {
        this.current = current;
        return this;
    }
}
