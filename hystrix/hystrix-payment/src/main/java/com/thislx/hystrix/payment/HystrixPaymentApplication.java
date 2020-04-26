package com.thislx.hystrix.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:41
 **/
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentApplication.class, args);
    }
}
