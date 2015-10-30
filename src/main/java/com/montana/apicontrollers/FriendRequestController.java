package com.montana.apicontrollers;

import com.montana.apimodels.FriendRequestAddModel;
import com.montana.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alexto on 29/10/15.
 */

@RestController
@RequestMapping(path = "api/friendrequests/")
public class FriendRequestController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FriendRequestAddModel> addFriendRequest(@Valid @RequestBody FriendRequestAddModel model)
    {
        model.setId(friendService.addFriendRequest(model.getSender(), model.getRecipient()));
        return new ResponseEntity<FriendRequestAddModel>(model, HttpStatus.CREATED);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity cancelFriendRequest(@PathVariable Long id)
    {
        friendService.cancelFriendRequest(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
