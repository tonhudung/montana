package com.montana.apicontrollers;

import com.montana.apimodels.ProfileViewModel;
import com.montana.services.SecurityContextAccessor;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private UserService userService;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    @RequestMapping(path = "/{userName}", method = RequestMethod.GET)
    public ProfileViewModel getProfile(@PathVariable String userName) {

        return userService.getProfileViewApiModel(securityContextAccessor.getCurrentUserName(), userName);
    }
}
