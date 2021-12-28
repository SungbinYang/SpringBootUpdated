package me.sungbin.demospringboot23prop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowController {

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        System.out.println("got the request");
        Thread.sleep(10000L);
        return "slow";
    }
}
