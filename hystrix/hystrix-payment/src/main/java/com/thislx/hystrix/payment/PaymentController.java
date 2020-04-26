package com.thislx.hystrix.payment;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:17
 **/
@RestController
public class PaymentController {


    /**
     * @HystrixCommand 配置降级处理，fallbackMethod指定降级后执行的方法，方法入参、出参必须保持一致
     *
     * @date 2020/4/26 18:37
     * @author lixiangx@leimingtech.com
     **/
    // TODO lixiang HystrixProperty注解含义
    @GetMapping("payment")
    @HystrixCommand(fallbackMethod = "defaultPayment", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getPayment() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix-payment";
    }


    public String defaultPayment() {
        return "hystrix-payment-default";
    }

}
