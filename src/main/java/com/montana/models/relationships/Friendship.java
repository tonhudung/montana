package com.montana.models.relationships;

import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * Created by alexto on 28/10/15.
 */

@RelationshipEntity(type = "FRIENDS")
public class Friendship {

    private Long id;

    public Long getId() {
        return id;
    }

    public Friendship setId(Long id) {
        this.id = id;
        return this;
    }
}
