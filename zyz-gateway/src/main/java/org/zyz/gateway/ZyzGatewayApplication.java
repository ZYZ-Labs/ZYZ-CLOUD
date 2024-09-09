package org.zyz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZyzGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyzGatewayApplication.class, args);
    }

}
