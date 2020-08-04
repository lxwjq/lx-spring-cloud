package com.thislx.hystrix.order;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:17
 **/
@Slf4j
@RestController
//@DefaultProperties(defaultFallback = "getGlobalPaymentFallback")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("payment")
    public Map<String, String> getPayment() {
        Map<String, String> map = new HashMap<>();
        String payment = paymentService.payment();
        map.put("result", payment);
        return map;
    }


    /**
     * 降级处理
     * 客户端降级方法
     * order调用payment  order设置超时时间为1.5s，payment服务端执行需要5秒钟，order服务直接进入降级方法
     * <p>
     * 缺点：
     * 1、代码膨胀，每一个业务方法都需要一个降级方法
     * 解决办法：定义统一的降级方法。
     * 客户端增加@DefaultProperties 业务方法上只增加@HystrixCommand使用全局降级方法。
     * 2、代码耦合度高，业务逻辑方法与服务降级方法揉在一起
     *
     * @date 2020/4/26 22:04
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("hystrix/payment")
    @HystrixCommand(fallbackMethod = "getPaymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
//    @HystrixCommand
    public Map<String, String> getHystrixPayment() {
        Map<String, String> map = new HashMap<>();
        String payment = paymentService.payment();
        map.put("result", payment);
        return map;
    }

    /**
     * 降级处理
     *
     * @date 2020/4/26 22:05
     * @author lixiangx@leimingtech.com
     **/
    public Map<String, String> getPaymentFallback() {
        Map<String, String> map = new HashMap<>();
        log.info("hystrix-order服务执行降级方法");
        map.put("result", "payment_fallback");
        return map;
    }

    /**
     * 降级处理（全局）
     *
     * @date 2020/4/26 22:05
     * @author lixiangx@leimingtech.com
     **/
    public Map<String, String> getGlobalPaymentFallback() {
        Map<String, String> map = new HashMap<>();
        log.info("hystrix-order服务执行全局降级方法");
        map.put("result", "payment_global_fallback");
        return map;
    }
}
