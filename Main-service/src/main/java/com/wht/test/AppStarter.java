package com.wht.test;

import cn.xuyanwu.spring.file.storage.EnableFileStorage;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import openfga.v1.OpenFGAServiceGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import oshi.SystemInfo;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:21
 */
@EnableFeignClients
//@EnableDiscoveryClient
@EnableWebSocket
@EnableFileStorage
@SpringBootApplication
public class AppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        return systemInfo;
    }

    @Bean
    public ManagedChannel getChannel() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.240.128", 8081)
                .usePlaintext()
                .build();
        return channel;
    }
    @Bean
    public OpenFGAServiceGrpc.OpenFGAServiceBlockingStub getStub(ManagedChannel channel) {
        return OpenFGAServiceGrpc.newBlockingStub(channel);
    }


}