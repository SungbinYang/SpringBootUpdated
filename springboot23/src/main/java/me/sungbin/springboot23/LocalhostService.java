package me.sungbin.springboot23;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class LocalhostService {

    public String getLocalHostInfo() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            return String.format("host-address: %s host-name: %s", localHost.getHostAddress(), localHost.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
