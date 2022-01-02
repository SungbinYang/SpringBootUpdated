package me.sungbin.demospringboot24;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class LocalhostService {

    public String getLocalHostInfo() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            return String.format("host-address: %s host-name: %s", inetAddress.getHostAddress(), inetAddress.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
