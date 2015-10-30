package com.montana.models.nodes;

import com.montana.apimodels.PostAddModel;
import com.montana.models.PostType;
import com.montana.models.StatusType;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.EnumString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex_to on 20/10/2015.
 */

public class Post {

    private Long id;

    private String message;

    @CreatedDate
    private Date createdDate;

    @Relationship(type = "HAS_LINK")
    private Link link;

    @Relationship(type = "HAS_VIDEO")
    private Video video;

    @Relationship(type = "HAS_PHOTOS")
    private Set<Photo> photos = new HashSet<Photo>();

    @CreatedBy
    @Relationship(type = "POSTED_BY", direction = Relationship.INCOMING)
    private User fromUser;

    @Relationship(type = "POSTED_TO")
    private User toUser;


    @EnumString(PostType.class)
    private PostType postType;

    @EnumString(StatusType.class)
    private StatusType statusType;

    public Post() {
        createdDate = new Date();
    }

    public static Post from(PostAddModel postAddModel) {
        return (new Post())
                .setMessage(postAddModel.getMessage());
    }

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Post setCreatedDate(Date createdDate) {
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

    public PostType getPostType() {
        return postType;
    }

    public Post setPostType(PostType postType) {
        this.postType = postType;
        return this;
    }

    public Video getVideo() {
        return video;
    }

    public Post setVideo(Video video) {
        this.video = video;
        return this;
    }

    public User getFromUser() {
        return fromUser;
    }

    public Post setFromUser(User fromUser) {
        this.fromUser = fromUser;
        return this;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public Post setStatusType(StatusType statusType) {
        this.statusType = statusType;
        return this;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public Post setPhotos(Set<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public User getToUser() {
        return toUser;
    }

    public Post setToUser(User toUser) {
        this.toUser = toUser;
        return this;
    }
}
