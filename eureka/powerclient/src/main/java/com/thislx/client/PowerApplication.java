package com.thislx.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/21 16:07
 **/
@SpringBootApplication
@EnableEurekaClient
public class PowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerApplication.class, args);
    }
}
