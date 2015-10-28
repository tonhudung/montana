package com.montana.apicontrollers;

import com.montana.apimodels.profile.FriendRequestCreateApiModel;
import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.apimodels.profile.ProfileViewApiModel;
import com.montana.services.FriendService;
import com.montana.services.PostService;
import com.montana.services.SecurityContextAccessor;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alexto on 19/10/15.
 */

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    public ProfileViewApiModel getProfile(@PathVariable String userName) {
        String currentUserName = securityContextAccessor.getCurrentUserName();
        return userService.getProfileViewApiModel(currentUserName, userName);
    }

    @RequestMapping(path = "/{userName}/posts", method = RequestMethod.GET)
    public ProfileViewApiModel getPosts(@PathVariable String userName) {
        return null;
    }

    @RequestMapping(path = "/{userName}/posts", method = RequestMethod.POST)
    public ResponseEntity addPost(@PathVariable String userName,
                                  @Valid @RequestBody PostCreateApiModel postCreateApiModel) {

        postService.addPost(userName, postCreateApiModel);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{userName}/posts/{postId}", method = RequestMethod.GET)
    public ProfileViewApiModel getPost(@PathVariable String userName, @PathVariable int postId) {
        return null;
    }

    @RequestMapping(path = "/{userName}/friends", method = RequestMethod.POST)
    public ResponseEntity addFriend(@PathVariable String userName, @Valid @RequestBody FriendRequestCreateApiModel friendRequestCreateApiModel) {
        friendService.sendFriendRequest(userName, friendRequestCreateApiModel.getFriendToBe());
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
