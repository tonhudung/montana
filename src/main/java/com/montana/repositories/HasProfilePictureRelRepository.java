package com.montana.repositories;

import com.montana.models.relationships.HasProfilePicture;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alext on 10/11/2015.
 */

@Repository
public interface HasProfilePictureRelRepository extends GraphRepository<HasProfilePicture> {
}
