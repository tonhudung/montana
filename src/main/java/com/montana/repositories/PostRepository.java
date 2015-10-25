package com.montana.repositories;

import com.montana.models.nodes.Post;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alext on 10/24/2015.
 */

@Repository
public interface PostRepository extends GraphRepository<Post> {
}
