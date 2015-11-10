package com.montana.controllers;

import com.montana.exceptions.NotFoundException;
import com.montana.models.nodes.User;
import com.montana.services.SecurityContextAccessor;
import com.montana.services.UserService;
import com.montana.viewmodels.home.ProfileViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by alext on 10/10/2015.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityContextAccessor securityContextAccessor;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(path = "{userName}")
    public ModelAndView profile(@PathVariable String userName, Model model, HttpServletResponse response) {

        User user = userService.findByUserName(userName);
        if (user == null) {
            throw new NotFoundException();
        }

        ProfileViewModel viewModel = (new ProfileViewModel())
                .setFirstName(user.getFirstName())
                .setUserName(user.getUserName());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/profile");
        modelAndView.addObject("profile", viewModel);

        //TODO: Remove this and implement in Authentication Success Handler instead
        response.addCookie(new Cookie("currentUser", securityContextAccessor.getCurrentUserName()));
        response.addCookie(new Cookie("currentUserFirstName", securityContextAccessor.getCurrentUser().getFirstName()));

        return modelAndView;
    }

}
