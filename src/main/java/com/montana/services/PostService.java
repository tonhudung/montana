package com.montana.services;

import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.models.nodes.Post;

/**
 * Created by alext on 10/24/2015.
 */


public interface PostService {

    void addPost(PostCreateApiModel postCreateApiModel);

    Post save(Post post);
}
