package com.thislx.hystrix.payment;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:17
 **/
@Slf4j
@RestController
public class PaymentController {


    /**
     * 降级配置
     * order 调用 payment
     * 对payment（服务端）进行降级
     * 一般降级方法放置在客户端
     * 【注】如果使用热部署，修改HystrixCommand注解中的方法建议重启，有可能不生效
     *
     * @HystrixCommand 配置降级处理，fallbackMethod指定降级后执行的方法，方法入参、出参必须保持一致
     * @date 2020/4/26 18:37
     * @author lixiangx@leimingtech.com
     **/
    // TODO lixiang yml配置文件配置全局
    // TODO lixiang HystrixProperty注解含义 各各参数含义
    @GetMapping("payment")
    @HystrixCommand(fallbackMethod = "defaultPayment", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getPayment() {
        try {
            log.info("当前线程名称" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10 / 0;
        return "hystrix-payment";
    }


    /**
     * 降级方法
     * 执行降级方法会另起一个线程进行执行
     *
     * @date 2020/4/26 21:45
     * @author lixiangx@leimingtech.com
     **/
    public String defaultPayment() {
        log.info("方法执行降级");
        log.info("当前线程名称" + Thread.currentThread().getName());
        return "hystrix-payment-default";
    }


    /************服务熔断 start************/
    /**
     * 熔断配置  详细见 HystrixCommandProperties类
     *
     * @date 2020/4/27 9:54
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("circuit/breaker/payment/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能位负数");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，" + id;
    }

    /************服务熔断 end**************/

}
