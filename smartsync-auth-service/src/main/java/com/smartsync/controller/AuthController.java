package com.smartsync.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * REST endpoint to be used by other services using SSO to validate the
 * authentication of of the logged in user
 *
 */
@RestController
@RequestMapping("/")
public class AuthController {


    @RequestMapping("/auth")
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }



}
