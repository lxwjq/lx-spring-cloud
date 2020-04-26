package com.thislx.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/26 9:36
 **/
@Configuration
public class OrderConfig {

    /**
     * 可以配置负载均衡规则，也可以自定义规则（继承AbstractLoadBalancerRule）
     *
     * @date 2020/4/25 18:26
     * @author lixiangx@leimingtech.com
     **/
    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }
}
