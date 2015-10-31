package com.montana.apicontrollers;

import com.montana.apimodels.FriendRequestAddModel;
import com.montana.apimodels.FriendRequestUpdateModel;
import com.montana.exceptions.BadRequestException;
import com.montana.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alexto on 29/10/15.
 */

@RestController
@RequestMapping(path = "api/{userName}/friendrequests/")
@PreAuthorize("#userName == principal.username")
public class FriendRequestController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addFriendRequest(@PathVariable String userName, @Valid @RequestBody FriendRequestAddModel model) {
        friendService.addFriendRequest(userName, model.getRecipient());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "{recipient}", method = RequestMethod.DELETE)
    public ResponseEntity cancelFriendRequest(@PathVariable String userName, @PathVariable String recipient) {
        friendService.cancelFriendRequest(userName, recipient);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateFriendRequest(@PathVariable String userName, @Valid @RequestBody FriendRequestUpdateModel model) {

        switch (model.getFriendRequestStatus())
        {
            case IGNORED:
                friendService.ignoreFriendRequest(model.getUser(), userName);
                break;
            case ACCEPTED:
                friendService.addFriendship(model.getUser(), userName);
                break;
            default:
                throw new BadRequestException();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
