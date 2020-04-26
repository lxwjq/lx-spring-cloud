package com.thislx.order;

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
@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("payment")
    public Map<String, String> getUser() {
        Map<String, String> map = new HashMap<>();
        String payment = paymentService.payment();
        map.put("result", payment);
        return map;
    }
}
