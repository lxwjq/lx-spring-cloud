package com.thislx.hystrix.order.impl;

import com.thislx.hystrix.order.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 必须增加@Component注解使此类注入到springbeanfactory中
 *
 * @author lixiang
 * @version V1.0
 * @date 2020/4/26 22:23
 **/
@Slf4j
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public String payment() {
        log.error("执行payment执行降级");
        return "payment_PaymentServiceFallback";
    }
}
