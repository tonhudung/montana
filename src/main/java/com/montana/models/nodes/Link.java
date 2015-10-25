package com.montana.models.nodes;

import com.montana.apimodels.profile.PostCreateApiModel;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by alex_to on 20/10/2015.
 */

@NodeEntity
public class Link {

    @GraphId
    private Long id;

    @URL
    private String url;

    @URL
    private String providerUrl;

    @Max(1000)
    private String title;

    @Max(1000)
    private String description;

    @CreatedDate
    private Long createdDate;

    public Link() {
        createdDate = (new Date()).getTime();
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public Link setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
