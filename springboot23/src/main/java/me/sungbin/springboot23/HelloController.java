package me.sungbin.springboot23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ApplicationAvailability applicationAvailability;

    @Autowired
    LocalhostService localhostService;

    @Autowired
    MyProperties myProperties;

    @GetMapping("/hello")
    public String hello() {
        return "Application is now " + applicationAvailability.getLivenessState() + " "
                + applicationAvailability.getReadinessState() + " " + localhostService.getLocalHostInfo()
                + " " + myProperties.getMessage();
    }
}
