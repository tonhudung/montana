package com.montana.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User{

    String firstName;
    String lastName;
    String email;
    String userName;
    String passwordHash;

}