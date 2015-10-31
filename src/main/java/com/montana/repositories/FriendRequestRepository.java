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

    @Query("MATCH (:User {userName:{0}})-[r:FRIEND_REQUEST]-(:User {userName:{1}}) RETURN r")
    FriendRequest find(String userA, String userB);

    @Query("MATCH (:User {userName:{0}})-[r:FRIEND_REQUEST]->(:User {userName:{1}}) RETURN r")
    FriendRequest findBySenderAndRecipient(String senderUserName, String recipientUserName);

    @Query("MATCH ()-[r:FRIEND_REQUEST]-() WHERE Id(r)={0} RETURN r")
    FriendRequest findById(Long id);
}
