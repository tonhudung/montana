package com.montana.services;

import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.exceptions.NotFoundException;
import com.montana.models.PostType;
import com.montana.models.StatusType;
import com.montana.models.nodes.*;
import com.montana.repositories.PostRepository;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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

    public void addPost(PostCreateApiModel postCreateApiModel) {

        User fromUser = userRepository.findByUserName(postCreateApiModel.getFromUser());

        if (fromUser == null)
            throw new NotFoundException();

        //TODO: permission to post to someone else's wall?


        Post post = Post.from(postCreateApiModel)
                .setFromUser(poster)
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

        postRepository.save(post);
    }
}
