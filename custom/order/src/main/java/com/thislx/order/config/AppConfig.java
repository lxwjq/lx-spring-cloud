package com.thislx.order.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 *
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:20
 **/
@Configuration
public class AppConfig {

    /**
     * 配置RestTemplate
     *
     * @date 2020/4/29 15:53
     * @author lixiangx@leimingtech.com
     **/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 配置tomcat端口
     *
     * @date 2020/4/29 15:53
     * @author lixiangx@leimingtech.com
     **/
    @Bean
    public TomcatServletWebServerFactory tomcat() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(8080);
        return tomcatServletWebServerFactory;
    }
}
