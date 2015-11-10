package com.montana.models.nodes;

import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alext on 10/11/2015.
 */

public class Photo {

    private Long id;

    private String url;

    private String providerUrl;

    private String providerName;

    private Integer width;

    private Integer height;

    @Relationship(type = "UPLOADED", direction = Relationship.INCOMING)
    private User user;

    @CreatedDate
    @DateLong
    private Date createdDate;

    public Photo() {
        createdDate = new Date();
    }

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

    public String getProviderUrl() {
        return providerUrl;
    }

    public Photo setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public Photo setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Photo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Photo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Photo setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
