package com.edigest.projectFirst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/home")
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${custom.logging.level:error}")
    private String logLevel;

    @GetMapping
    public String hello(
            @RequestParam(defaultValue = "default value", required = false) String value
    ) {
        switch (logLevel.toUpperCase()) {
            case "DEBUG":
                logger.debug("DEBUG: This is API calling {}", value);
                break;
            case "INFO":
                logger.info("INFO: This is API calling {}", value);
                break;
            case "ERROR":
                logger.error("ERROR: This is API calling {}", value);
                break;
            case "WARN":
                logger.warn("WARN: This is API calling {}", value);
                break;
            case "TRACE":
                logger.trace("TRACE: This is API calling {}", value);
                break;
            default:
                logger.info("Default INFO: This is API calling {}", value);
        }
        return "This is home API";
    }
}
