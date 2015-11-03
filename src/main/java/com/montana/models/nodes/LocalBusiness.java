package com.montana.models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.Set;

/**
 * Created by alex on 3/11/15.
 */

@NodeEntity
public class LocalBusiness {
    private Long id;
    private String name;
    private String description;
    private String phone;
    private Address address;

    @Relationship(type = "OWNS", direction = Relationship.INCOMING)
    private User owner;

    @Relationship(type="HAS_PRODUCT")
    private Set<Product> products;

    @Relationship(type = "HAS_CATEGORY")
    private Set<ProductCategory> productCategories;

    @CreatedDate
    @DateLong
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public LocalBusiness setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocalBusiness setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LocalBusiness setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public LocalBusiness setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public LocalBusiness setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public LocalBusiness setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public LocalBusiness setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public LocalBusiness setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public LocalBusiness setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
        return this;
    }
}
