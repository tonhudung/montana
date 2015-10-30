package com.montana.models.nodes;

import com.montana.apimodels.PostAddModel;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alext on 10/24/2015.
 */

public class Video {

    private Long id;

    private String url;

    private String providerUrl;

    private String title;

    private String description;

    private Integer width;

    private Integer height;

    private String thumbnailUrl;

    private Integer thumbnailWidth;

    private Integer thumbnailHeight;

    private String authorName;

    private String authorUrl;

    private String html;

    @CreatedDate
    @DateLong
    private Date createdDate;

    public Video() {
        createdDate = new Date();
    }

    public static Video from(PostAddModel postAddModel) {
        return (new Video())
                .setUrl(postAddModel.getUrl())
                .setProviderUrl(postAddModel.getProviderUrl())
                .setTitle(postAddModel.getTitle())
                .setDescription(postAddModel.getDescription())
                .setWidth(postAddModel.getWidth())
                .setHeight(postAddModel.getHeight())
                .setThumbnailUrl(postAddModel.getThumbnailUrl())
                .setThumbnailWidth(postAddModel.getThumbnailWidth())
                .setThumbnailHeight(postAddModel.getThumbnailHeight())
                .setAuthorName(postAddModel.getAuthorName())
                .setAuthorUrl(postAddModel.getAuthorUrl())
                .setHtml(postAddModel.getHtml());

    }

    public Long getId() {
        return id;
    }

    public Video setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Video setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public Video setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Video setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Video setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Video setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Video setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Video setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public Video setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public Video setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Video setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public Video setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
        return this;
    }

    public String getHtml() {
        return html;
    }

    public Video setHtml(String html) {
        this.html = html;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Video setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
