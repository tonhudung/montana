package com.montana.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alext on 10/10/2015.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "home/index";
    }
}
