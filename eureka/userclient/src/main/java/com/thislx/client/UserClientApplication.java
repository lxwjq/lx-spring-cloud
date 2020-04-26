package com.thislx.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/21 15:59
 **/
// TODO lixiang eureka缓存配置
@SpringBootApplication
@EnableEurekaClient
public class UserClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }
}
