package com.montana.apicontrollers;

import com.montana.apimodels.profile.FriendRequestCreateApiModel;
import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.apimodels.profile.ProfileViewApiModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.PostType;
import com.montana.models.StatusType;
import com.montana.models.nodes.*;
import com.montana.services.PostService;
import com.montana.services.SecurityContextAccessor;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

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
    private PostService postService;

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    public ProfileViewApiModel getProfile(@PathVariable String userName) {
        User user = userService.findByUserName(userName);

        if (user == null)
            throw new NotFoundException();

        String currentUserName = securityContextAccessor.getCurrentUserName();

        return (new ProfileViewApiModel())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfilePictureUrl(user.getProfilePicture().getUrl())
                .setIsFriend(userService.isFriend(currentUserName, userName));
    }

    @RequestMapping(path = "/{userName}/posts", method = RequestMethod.GET)
    public ProfileViewApiModel getPosts(@PathVariable String userName) {
        return null;
    }

    @RequestMapping(path = "/{userName}/posts", method = RequestMethod.POST)
    public ResponseEntity addPost(@PathVariable String userName,
                                     @Valid @RequestBody PostCreateApiModel postCreateApiModel) {

        //TODO: permission to post to someone else's wall?
        User user = userService.findByUserName(userName);

        if (user == null)
            throw new NotFoundException();

        Post post = Post.from(postCreateApiModel)
                .setUser(user)
                .setPostType(PostType.STATUS)
                .setStatusType(StatusType.MOBILE_STATUS_UPDATE);

        if (postCreateApiModel.getType().equalsIgnoreCase("video")) {
            post.setVideo(Video.from(postCreateApiModel))
                    .setPostType(PostType.VIDEO)
                    .setStatusType(StatusType.SHARED_STORY);

        } else if (postCreateApiModel.getType().equalsIgnoreCase("link")) {
            post.setLink(Link.from(postCreateApiModel))
                    .setStatusType(StatusType.SHARED_STORY)
                    .setPostType(PostType.LINK);

        } else if (postCreateApiModel.getType().equalsIgnoreCase("photo")) {
            ArrayList<Photo> photos = new ArrayList<Photo>();
            photos.add(Photo.from(postCreateApiModel));
            post.setPhotos(photos)
                    .setStatusType(StatusType.SHARED_STORY)
                    .setPostType(PostType.PHOTO);
        }

        postService.save(post);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{userName}/posts/{postId}", method = RequestMethod.GET)
    public ProfileViewApiModel getPost(@PathVariable String userName, @PathVariable int postId) {
        return null;
    }

    @RequestMapping(path = "/{userName}/friends", method = RequestMethod.POST)
    public ResponseEntity addFriend(@PathVariable String userName, @Valid @RequestBody FriendRequestCreateApiModel friendRequestCreateApiModel)
    {
        return null;
    }

}
