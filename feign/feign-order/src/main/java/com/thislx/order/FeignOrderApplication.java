package com.thislx.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:41
 **/
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class, args);
    }
}
