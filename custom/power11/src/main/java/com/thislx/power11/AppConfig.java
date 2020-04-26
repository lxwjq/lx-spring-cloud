package com.thislx.power11;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:20
 **/
@Configuration
public class AppConfig {

    @Bean
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(6001);
        return tomcatServletWebServerFactory;
    }
}
