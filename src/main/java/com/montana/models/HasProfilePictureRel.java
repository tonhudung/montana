package com.montana.models;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by alext on 10/11/2015.
 */

@RelationshipEntity(type = "HAS_PROFILE_PICTURE")
public class HasProfilePictureRel {

    @GraphId Long id;
    @StartNode Photo photo;
    @EndNode User user;

    boolean current;

    public Long getId() {
        return id;
    }

    public HasProfilePictureRel setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public HasProfilePictureRel setUser(User user) {
        this.user = user;
        return this;
    }

    public Photo getPhoto() {
        return photo;
    }

    public HasProfilePictureRel setPhoto(Photo photo) {
        this.photo = photo;
        return this;
    }

    public boolean isCurrent() {
        return current;
    }

    public HasProfilePictureRel setCurrent(boolean current) {
        this.current = current;
        return this;
    }
}
