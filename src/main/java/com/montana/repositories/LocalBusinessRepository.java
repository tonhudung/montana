package com.montana.repositories;

import com.montana.models.nodes.LocalBusiness;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 3/11/15.
 */

@Repository
public interface LocalBusinessRepository extends GraphRepository<LocalBusiness> {
}
