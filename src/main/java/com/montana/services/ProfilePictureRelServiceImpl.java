package com.montana.services;

import com.montana.models.ProfilePictureRel;
import com.montana.repositories.ProfilePictureRelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;

/**
 * Created by alext on 10/11/2015.
 */

@Service
public class ProfilePictureRelServiceImpl implements ProfilePictureRelService {
    @Autowired
    ProfilePictureRelRepository profilePictureRelRepository;

    public ProfilePictureRel save(ProfilePictureRel profilePictureRel) {
        return profilePictureRelRepository.save(profilePictureRel);
    }
}
