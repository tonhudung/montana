package com.montana.apicontrollers;

import com.montana.apimodels.User;
import com.montana.apimodels.ProfileViewModel;
import com.montana.services.SecurityContextAccessor;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexto on 19/10/15.
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    @RequestMapping(path = "/current")
    public ResponseEntity<User> getCurrentUser()
    {
        return new ResponseEntity<User>(User.from(securityContextAccessor.getCurrentUser()), HttpStatus.OK);
    }

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    public ProfileViewModel getProfile(@PathVariable String userName) {
        return null;
        //return userService.getProfileViewApiModel(securityContextAccessor.getCurrentUserName(), userName);
    }
}
