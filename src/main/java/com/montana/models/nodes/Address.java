package com.montana.models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by alex on 3/11/15.
 */

@NodeEntity
public class Address {

    private Long id;
    private String streetAddress;
    private String city;
    private String country;
    private String postal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Address setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPostal() {
        return postal;
    }

    public Address setPostal(String postal) {
        this.postal = postal;
        return this;
    }
}
