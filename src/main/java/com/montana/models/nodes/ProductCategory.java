package com.montana.models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by alex on 3/11/15.
 */
@NodeEntity
public class ProductCategory {

    private Long id;
    private String name;
    private String description;
    
    @CreatedDate
    @DateLong
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public ProductCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public ProductCategory setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
