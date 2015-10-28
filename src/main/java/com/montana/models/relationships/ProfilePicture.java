package com.montana.models.relationships;

import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by alext on 10/11/2015.
 */

@RelationshipEntity(type = "HAS_PROFILE_PICTURE")
public class ProfilePicture {

    private Long id;

    @StartNode
    private User user;

    @EndNode
    private Photo photo;

    private Boolean current;

    public Long getId() {
        return id;
    }

    public ProfilePicture setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ProfilePicture setUser(User user) {
        this.user = user;
        return this;
    }

    public Photo getPhoto() {
        return photo;
    }

    public ProfilePicture setPhoto(Photo photo) {
        this.photo = photo;
        return this;
    }

    public Boolean isCurrent() {
        return current;
    }

    public ProfilePicture setCurrent(Boolean current) {
        this.current = current;
        return this;
    }
}
