package com.thislx.user;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/25 17:44
 **/
@Configuration
public class AppConfig {

    /**
     * 在RestTemplate上面加入@LoadBalanced注解，这样子就已经有了负载均衡，
     *
     * @date 2020/4/25 18:20
     * @author lixiangx@leimingtech.com
     **/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    /**
//     * 可以配置负载均衡规则，也可以自定义规则（继承AbstractLoadBalancerRule）
//     *
//     * @date 2020/4/25 18:26
//     * @author lixiangx@leimingtech.com
//     **/
//    @Bean
//    public IRule iRule() {
//        return new RoundRobinRule();
//    }

}
