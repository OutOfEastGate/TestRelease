package com.wht.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:23
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class SearchAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(SearchAppStarter.class, args);
    }
}
