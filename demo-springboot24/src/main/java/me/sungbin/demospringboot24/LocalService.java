package me.sungbin.demospringboot24;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("localService")
@Service
public class LocalService implements MyService {

    @Override
    public String getMessage() {
        return "local";
    }
}
