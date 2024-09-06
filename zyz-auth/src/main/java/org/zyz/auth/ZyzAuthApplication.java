package org.zyz.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZyzAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyzAuthApplication.class, args);
    }

}
