package com.montana.models.nodes;

import com.montana.apimodels.profile.PostCreateApiModel;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by alex_to on 20/10/2015.
 */

public class Link {

    private Long id;

    private String url;

    private String providerUrl;

    private String title;

    private String description;

    @CreatedDate
    @DateLong
    private Date createdDate;

    public Link() {
        createdDate = new Date();
    }

    public static Link from(PostCreateApiModel postCreateApiModel) {
        return (new Link());
    }

    public Long getId() {
        return id;
    }

    public Link setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Link setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public Link setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Link setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Link setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Link setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
