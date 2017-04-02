package com.smartsync.controller;

import com.smartsync.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

/**
 * Created by trev on 4/1/17.
 */
@RestController
public class AuthContoller {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private AuthService authService;

    public AuthContoller() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = "application/json")
    public ResponseEntity logIn(@RequestBody String googleId) {
        logger.info("Just recieved login Attempt from: " + googleId);

    }

}
