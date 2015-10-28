package com.montana.repositories;

import com.montana.models.relationships.Friendship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex_to on 28/10/2015.
 */

@Repository
public interface FriendshipRepository extends GraphRepository<Friendship> {

    @Query("MATCH (a:User {userName:{0}})-[r:FRIENDS]-(b:User{userName:{1}}) RETURN r")
    Friendship find(String userA, String userB);
}
