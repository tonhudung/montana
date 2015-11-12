package com.montana.apicontrollers;

import com.montana.apimodels.LoginRequest;
import com.montana.apimodels.LoginResponse;
import com.montana.models.nodes.User;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.ws.Response;

/**
 * Created by alext on 11/12/2015.
 */

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<String> get()
    {
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @RequestMapping(path = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<LoginResponse>(LoginResponse.from(user), HttpStatus.OK);
    }
}
