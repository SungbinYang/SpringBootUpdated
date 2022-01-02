package me.sungbin.demospringboot24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("localController")
@RestController
public class LocalController {

    @Autowired MyService myService;

    @GetMapping("/local")
    public String hello() {
        return myService.getMessage();
    }
}
