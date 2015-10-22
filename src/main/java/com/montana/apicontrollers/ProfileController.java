package com.montana.apicontrollers;

import com.montana.apimodels.profile.ProfileApiModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.nodes.User;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexto on 19/10/15.
 */

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    public ProfileApiModel index(@PathVariable String userName) {
        User user = userService.findByUserName(userName);

        if (user == null)
            throw new NotFoundException();

        ProfileApiModel profileApiModel = new ProfileApiModel();
        profileApiModel
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getUrl());

        return profileApiModel;
    }

    @RequestMapping(path = "/{userName}/posts", method = RequestMethod.GET)
    public ProfileApiModel getPosts(@PathVariable String userName) {
        return null;
    }

    @RequestMapping(path = "/{userName}/posts/{postId}", method = RequestMethod.GET)
    public ProfileApiModel getPost(@PathVariable String userName, @PathVariable int postId) {
        return null;
    }

}
