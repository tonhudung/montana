package com.montana.controllers;

import com.montana.repositories.UserRepository;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alexto on 10/10/15.
 */

@Controller
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "upload", method = RequestMethod.GET)
    public String upload() {
        userService.AddUser();
        return "import/upload";
    }

}
