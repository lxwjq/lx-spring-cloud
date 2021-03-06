package com.thislx.hystrix.order;

import com.thislx.hystrix.order.impl.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/26 10:56
 **/
@FeignClient(value = "HYSTRIX-PAYMENT")
//@FeignClient(value = "HYSTRIX-PAYMENT", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("payment")
    String payment();
}
