package com.montana.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alext on 10/10/2015.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }
}
