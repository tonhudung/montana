package com.montana.services;

import com.montana.apimodels.profile.ProfileViewApiModel;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;

/**
 * Created by alexto on 10/10/15.
 */

public interface UserService {
    User save(User user);

    User findByUserName(String userName);

    ProfileViewApiModel getProfileViewApiModel(String vieweeUserName);

    void setProfilePicture(Photo photo);
}
