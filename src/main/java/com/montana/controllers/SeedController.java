package com.montana.controllers;

import com.montana.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/seed/")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity index() throws IOException, ParseException {

        String source = servletContext.getRealPath("/seed/");
        String dest = servletContext.getRealPath("/uploads/");

        seedService.seed(source, dest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "tx", method = RequestMethod.GET)
    public ResponseEntity testTransaction() throws Exception {
        seedService.testTx();
        return new ResponseEntity(HttpStatus.OK);
    }

}
