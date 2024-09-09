package org.zyz.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class ZyzAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyzAuthApplication.class, args);
    }

}
