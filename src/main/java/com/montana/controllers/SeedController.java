package com.montana.controllers;

import com.montana.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by alexto on 10/10/15.
 */

@Controller
@RequestMapping("/seed")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() throws IOException, ParseException {

        String source = servletContext.getRealPath("/seed/");
        String dest = servletContext.getRealPath("/uploads/");

        seedService.seed(source, dest);
        return "seed/complete";
    }

    @RequestMapping(path = "/tx", method = RequestMethod.GET)
    public String testTransaction() throws Exception {

        //TODO: transaction does not seem to work
        seedService.testTx();
        return "seed/tx";
    }

}
