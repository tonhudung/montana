package com.montana.repositories;

import com.montana.models.relationships.LocalBusinessOwner;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 3/11/15.
 */

@Repository
public interface LocalBusinessOwnerRepository extends GraphRepository<LocalBusinessOwner> {

}