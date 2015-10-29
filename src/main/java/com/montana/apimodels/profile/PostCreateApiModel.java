package com.montana.apimodels.profile;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/**
 * Created by alext on 10/23/2015.
 */
public class PostCreateApiModel {

    //TODO: check validation

    @NotBlank
    private String fromUser;

    @NotBlank
    private String toUser;

    private String type;

    @URL
    private String url;

    @URL
    private String providerUrl;

    private String providerName;

    @NotBlank
    private String message;

    private String title;

    private String description;
    private Integer width;
    private Integer height;
    @URL
    private String thumbnailUrl;
    private Integer thumbnailWidth;
    private Integer thumbnailHeight;
    private String authorName;

    @URL
    private String authorUrl;
    private String html;

    public String getType() {
        return type;
    }

    public PostCreateApiModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PostCreateApiModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public PostCreateApiModel setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public PostCreateApiModel setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostCreateApiModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostCreateApiModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public PostCreateApiModel setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public PostCreateApiModel setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public PostCreateApiModel setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public PostCreateApiModel setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public PostCreateApiModel setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public PostCreateApiModel setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public PostCreateApiModel setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
        return this;
    }

    public String getHtml() {
        return html;
    }

    public PostCreateApiModel setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
