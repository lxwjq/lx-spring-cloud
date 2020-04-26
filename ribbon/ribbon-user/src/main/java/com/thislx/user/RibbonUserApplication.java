package com.thislx.user;

import com.thislx.config.OrderConfig;
import com.thislx.config.OtherConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 使用@RibbonClients配置多种负载均衡策略
 *
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:41
 **/
@EnableEurekaClient
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "RIBBON-ORDER", configuration = OrderConfig.class),
        @RibbonClient(name = "RIBBON-OTHER", configuration = OtherConfig.class)
})
public class RibbonUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonUserApplication.class, args);
    }
}
