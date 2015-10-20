package com.montana.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * Created by alexto on 20/10/15.
 */

@RelationshipEntity
public class FriendRequest {
    @GraphId
    Long id;
}
