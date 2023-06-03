package com.wht.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:16
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class GatewayAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayAppStarter.class,args);
    }
}
