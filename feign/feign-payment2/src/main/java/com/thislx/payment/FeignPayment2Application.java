package com.thislx.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:41
 **/
@EnableEurekaClient
@SpringBootApplication
public class FeignPayment2Application {
    public static void main(String[] args) {
        SpringApplication.run(FeignPayment2Application.class, args);
    }
}
