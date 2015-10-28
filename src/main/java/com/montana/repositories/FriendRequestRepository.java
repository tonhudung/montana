package com.montana.repositories;

import com.montana.models.relationships.FriendRequest;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexto on 27/10/15.
 */

@Repository
public interface FriendRequestRepository extends GraphRepository<FriendRequest> {

    @Query("MATCH (a:User {userName:{0}})-[r:FriendRequest]->(b:User {userName:{1}}) RETURN r")
    FriendRequest findBySenderAndRecipient(String sender, String recipient);
}
