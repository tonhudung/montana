package com.montana.models.relationships;

import com.montana.models.nodes.LocalBusiness;
import com.montana.models.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by alex on 3/11/15.
 */

@RelationshipEntity(type = "OWNS")
public class LocalBusinessOwnership {
    private Long id;

    @StartNode
    private User owner;

    @EndNode
    private LocalBusiness localBusiness;

    public Long getId() {
        return id;
    }

    public LocalBusinessOwnership setId(Long id) {
        this.id = id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public LocalBusinessOwnership setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public LocalBusiness getLocalBusiness() {
        return localBusiness;
    }

    public LocalBusinessOwnership setLocalBusiness(LocalBusiness localBusiness) {
        this.localBusiness = localBusiness;
        return this;
    }
}
