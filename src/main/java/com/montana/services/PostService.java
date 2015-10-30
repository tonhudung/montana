package com.montana.services;

import com.montana.apimodels.PostAddModel;
import com.montana.models.nodes.Post;

/**
 * Created by alext on 10/24/2015.
 */


public interface PostService {

    void addPost(PostAddModel postAddModel);

    Post save(Post post);
}
