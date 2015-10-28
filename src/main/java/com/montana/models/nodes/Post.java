package com.montana.models.nodes;

import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.models.PostType;
import com.montana.models.StatusType;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

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
    private List<Photo> photos;

    @CreatedBy
    @Relationship(type = "POSTED", direction = Relationship.INCOMING)
    private User user;

    private PostType postType;

    private StatusType statusType;

    public Post() {
        createdDate = new Date();
    }

    public static Post from(PostCreateApiModel postCreateApiModel) {
        return (new Post())
                .setMessage(postCreateApiModel.getMessage());
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

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public Post setStatusType(StatusType statusType) {
        this.statusType = statusType;
        return this;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Post setPhotos(List<Photo> photos) {
        this.photos = photos;
        return this;
    }
}
