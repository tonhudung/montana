package com.montana.services;

import com.montana.models.HasProfilePictureRel;
import com.montana.repositories.HasProfilePictureRelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alext on 10/11/2015.
 */

@Service
public class HasProfilePictureRelServiceImpl implements HasProfilePictureRelService {
    @Autowired
    HasProfilePictureRelRepository hasProfilePictureRelRepository;

    public HasProfilePictureRel save(HasProfilePictureRel hasProfilePictureRel) {
        return hasProfilePictureRelRepository.save(hasProfilePictureRel);
    }
}
