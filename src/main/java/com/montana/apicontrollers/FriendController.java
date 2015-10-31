package com.montana.apicontrollers;

import com.montana.apimodels.FriendshipAddModel;
import com.montana.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alexto on 31/10/15.
 */

@RestController
@RequestMapping(path = "/api/{userName}/friends/")
@PreAuthorize("#userName == principal.username")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(path = "{friendUserName}")
    public ResponseEntity unfriend(@PathVariable String userName, @PathVariable String friendUserName)
    {
        friendService.unfriend(userName, friendUserName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
