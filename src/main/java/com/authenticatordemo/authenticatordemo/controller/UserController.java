package com.authenticatordemo.authenticatordemo.controller;

import com.authenticatordemo.authenticatordemo.utils.language.CustomLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;


/**
 * User controller defines RESP APIs that can be used by the all users on the common portal
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CustomLocaleResolver customLocaleResolver;

    @GetMapping("/")
    public String homeUserController(HttpServletRequest request) {
        logger.info("Retrieve common data");
        return messageSource.getMessage("homepage", null, customLocaleResolver.resolveLocale(request));
    }
}
