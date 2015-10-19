package com.montana.apicontrollers;

import com.montana.models.User;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexto on 19/10/15.
 */

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public User index() {
        User user = userService.findByUserName("aaronp");
        return user;
    }
}
