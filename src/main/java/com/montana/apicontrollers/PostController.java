package com.montana.apicontrollers;

import com.montana.apimodels.profile.PostCreateApiModel;
import com.montana.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by alexto on 20/10/15.
 */

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity addPost(@Valid @RequestBody PostCreateApiModel postCreateApiModel) {

        postService.addPost(postCreateApiModel);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}