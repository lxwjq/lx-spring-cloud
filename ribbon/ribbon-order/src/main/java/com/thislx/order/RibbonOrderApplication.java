package com.thislx.order;

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
public class RibbonOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonOrderApplication.class, args);
    }
}
