package com.montana.controllers;

import com.montana.services.SecurityContextAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    SecurityContextAccessor securityContextAccessor;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register() {
        if (!securityContextAccessor.isAnonymous())
        {
            return "redirect:/";
        }
        return "account/register";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginGET()
    {
        if (!securityContextAccessor.isAnonymous())
        {
            return "redirect:/";
        }
        return "account/login";
    }
}