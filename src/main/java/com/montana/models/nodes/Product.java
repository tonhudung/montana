package com.montana.models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 3/11/15.
 */

@NodeEntity
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    @Relationship(type = "BELONGS_TO")
    private Set<ProductCategory> categories;

    @Relationship(type = "HAS_PHOTO")
    private Set<Photo> photos = new HashSet<Photo>();

    private Set<String> tags = new HashSet<String>();

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Product setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Set<String> getTags() {
        return tags;
    }

    public Product setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public Product setPhotos(Set<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public Product setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
        return this;
    }
}
