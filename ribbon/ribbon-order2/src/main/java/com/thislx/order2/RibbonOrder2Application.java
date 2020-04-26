package com.thislx.order2;

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
public class RibbonOrder2Application {
    public static void main(String[] args) {
        SpringApplication.run(RibbonOrder2Application.class, args);
    }
}
