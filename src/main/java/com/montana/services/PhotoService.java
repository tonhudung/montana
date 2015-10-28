package com.montana.services;

import com.montana.models.nodes.Photo;
import com.montana.models.relationships.ProfilePicture;

public interface PhotoService {
    Photo save(Photo photo);

    ProfilePicture save(ProfilePicture profilePicture);
}