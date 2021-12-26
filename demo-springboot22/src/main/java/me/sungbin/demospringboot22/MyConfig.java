package me.sungbin.demospringboot22;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MyConfig {

    @Bean
    public Object myBean() {
        return new Object();
    }
}
