package com.smartsync.controller;

import com.smartsync.model.Auth;
import com.smartsync.service.AuthService;
import model.UserPOJO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import communication.UserServiceCommunication;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * Created by trev on 4/1/17.
 */
@RestController
public class AuthContoller {

    private final Logger logger = Logger.getLogger(this.getClass());

    private  UserServiceCommunication userServiceCommunication =
            new UserServiceCommunication();

    @Autowired
    private AuthService authService;

    public AuthContoller() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = "application/json")
    public ResponseEntity logIn(@RequestHeader String googleId) {
        logger.info("Just recieved login Attempt from: " + googleId);
        UserPOJO authUser = userServiceCommunication.getUserByGoogleId(googleId);

        if(authUser == null) {
            //throw exception
        } else {
            UUID newSessionId = UUID.randomUUID();
            Auth newAuth = new Auth(authUser.getUserId(),
                    newSessionId.toString(), authUser.getRole());

            authService.addAuth(newAuth);
            return ResponseEntity.ok(newAuth.getSessionId());
        }

        //TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/logout", produces = "application/json")
    public ResponseEntity logOut(@RequestHeader String sessionId) {
        logger.info("Just recieved logout attmept");
        Auth userAuth = authService.removeAuth(sessionId);

        if(userAuth == null) {
            //throw exception
        } else {
            logger.info(userAuth.getUserId() + " successfully logged out");
            return ResponseEntity.ok(userAuth.getUserId());
        }

        //TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validate", produces = "application/json")
    public ResponseEntity authenticate(@RequestHeader String sessionId) {
        logger.info("Trying to authenticate");
        Auth userAuth = authService.getAuthBySessionId(sessionId);

        if(userAuth == null) {
            //throw exception
        } else {
            logger.info(userAuth.getUserId() + " Authenticated");
            return ResponseEntity.ok(true);
        }


        //TODO
        return null;
    }

}
