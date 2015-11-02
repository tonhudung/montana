package com.montana.services;

import com.montana.apimodels.PostAddModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.PostType;
import com.montana.models.StatusType;
import com.montana.models.nodes.*;
import com.montana.repositories.PostRepository;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alext on 10/24/2015.
 */

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Long addPost(PostAddModel postAddModel) {

        User fromUser = userRepository.findByUserName(postAddModel.getFromUser());

        if (fromUser == null)
            throw new NotFoundException();

        //TODO: permission to post to someone else's wall?

        Post post = Post.from(postAddModel)
                .setFromUser(fromUser)
                .setPostType(PostType.STATUS)
                .setStatusType(StatusType.MOBILE_STATUS_UPDATE);

        if (postAddModel.getType().equalsIgnoreCase("video")) {
            post.setVideo(Video.from(postAddModel))
                    .setPostType(PostType.VIDEO)
                    .setStatusType(StatusType.SHARED_STORY);

        } else if (postAddModel.getType().equalsIgnoreCase("link")) {
            post.setLink(Link.from(postAddModel))
                    .setStatusType(StatusType.SHARED_STORY)
                    .setPostType(PostType.LINK);

        } else if (postAddModel.getType().equalsIgnoreCase("photo")) {
            post.setStatusType(StatusType.SHARED_STORY)
                    .setPostType(PostType.PHOTO)
                    .getPhotos()
                    .add(Photo.from(postAddModel));
        }
        return postRepository.save(post).getId();
    }
}
