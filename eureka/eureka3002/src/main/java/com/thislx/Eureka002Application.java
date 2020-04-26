package com.thislx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/21 15:25
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka002Application.class, args);
    }
}
