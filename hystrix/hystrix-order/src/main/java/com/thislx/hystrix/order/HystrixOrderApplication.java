package com.thislx.hystrix.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:41
 **/
//  EnableHystrix与EnableCircuitBreaker区别
//  (1)、查看源码可知，@EnableHystrix注解的作用和@EnableCircuitBreaker注解的作用一样，@EnableHystrix注解对
//     @EnableCircuitBreaker注解进行了封装；

@EnableHystrix
//@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HystrixOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication.class, args);
    }
}
