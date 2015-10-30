package com.montana.apicontrollers;

import com.montana.apimodels.FriendRequestAddModel;
import com.montana.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
