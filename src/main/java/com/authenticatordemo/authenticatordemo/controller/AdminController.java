package com.authenticatordemo.authenticatordemo.controller;

import com.authenticatordemo.authenticatordemo.utils.language.CustomLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Admin controller defines RESP APIs that can be used by the manager on the admin portal
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CustomLocaleResolver customLocaleResolver;

    @GetMapping("/")
    public String homeAdminController(HttpServletRequest request) {
        logger.info("Retrieve admin data");
        return messageSource.getMessage("managerPage", null, customLocaleResolver.resolveLocale(request));
    }
}
