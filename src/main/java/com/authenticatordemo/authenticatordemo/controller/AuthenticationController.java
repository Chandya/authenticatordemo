package com.authenticatordemo.authenticatordemo.controller;

import com.authenticatordemo.authenticatordemo.models.rest.Response;
import com.authenticatordemo.authenticatordemo.models.rest.Request;
import com.authenticatordemo.authenticatordemo.models.User;
import com.authenticatordemo.authenticatordemo.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authService;

    /** This method is for internal purposes to create users */
    @PostMapping("/register")
    public User registerUser(@RequestBody Request body){
        logger.info("Register a user with name, username and password");
        return authService.registerUser(body.getName(), body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public Response loginUser(@RequestBody Request body) {
        logger.info("Login API with username and password");
        return authService.loginUser(body.getUsername(), body.getPassword());
    }
}
