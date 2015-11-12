package com.montana.repositories;

import com.montana.models.nodes.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alext on 10/10/2015.
 */

@Repository
public interface UserRepository extends GraphRepository<User> {

    User findByEmail(String email);

    User findByUserName(String userName);

    User findByEmailAndPassword(String email, String password);

    @Query("OPTIONAL MATCH (userA:User {userName:{0}})-[f:FRIENDS]-(userB:User {userName:{1}}) RETURN f IS NOT NULL AS isFriend")
    boolean isFriend(String userA, String userB);
}
