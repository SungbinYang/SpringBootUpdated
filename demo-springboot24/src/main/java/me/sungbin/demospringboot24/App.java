package me.sungbin.demospringboot24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class App {

    @Value("${my.message}")
    private String myMessage;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> System.out.println(myMessage +
                " " + Arrays.toString(environment.getActiveProfiles()) +
                " " + Arrays.toString(environment.getDefaultProfiles()));
    }
}
