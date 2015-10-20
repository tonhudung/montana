package com.montana.repositories;

import com.montana.models.nodes.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alext on 10/10/2015.
 */

@Repository
public interface UserRepository extends GraphRepository<User> {

    User findByEmail(String email);

    User findByUserName(String userName);
}
