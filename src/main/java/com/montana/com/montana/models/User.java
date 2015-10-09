package com.montana.com.montana.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User{

    @GraphId
    Long id;

    String firstName;
    String lastName;
    String email;
}