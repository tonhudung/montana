package com.montana.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "account/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET()
    {
        return "account/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST()
    {
        return "";
    }

}