package com.montana.controllers;

import com.montana.exceptions.NotFoundException;
import com.montana.models.User;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alext on 10/10/2015.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }


    @RequestMapping(value = "/{userName}")
    public String profile(@PathVariable String userName, Model model) {

        User user = userService.findByUserName(userName);
        if (user == null)
        {
            throw new NotFoundException();
        }

        model.addAttribute("userName", userName);
        return "home/profile";
    }

}
