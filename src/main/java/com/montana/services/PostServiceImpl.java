package com.montana.services;

import com.montana.models.nodes.Post;
import com.montana.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alext on 10/24/2015.
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
