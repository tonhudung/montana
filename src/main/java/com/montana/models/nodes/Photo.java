package com.montana.models.nodes;

import com.montana.apimodels.profile.PostCreateApiModel;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alext on 10/11/2015.
 */

@NodeEntity
public class Photo {

    @GraphId
    private Long id;

    private String url;

    private String providerUrl;

    private String providerName;

    private Integer width;

    private Integer height;

    @CreatedDate
    private Long createdDate;

    public Photo() {
        createdDate = (new Date()).getTime();
    }

    public static Photo from(PostCreateApiModel postCreateApiModel) {
        return (new Photo())
                .setUrl(postCreateApiModel.getUrl())
                .setProviderUrl(postCreateApiModel.getProviderUrl())
                .setProviderName(postCreateApiModel.getProviderName())
                .setWidth(postCreateApiModel.getWidth())
                .setHeight(postCreateApiModel.getHeight());
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public Photo setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
