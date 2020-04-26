package com.thislx.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:17
 **/
@RestController
public class PaymentController {


    @GetMapping("payment")
    public String getPayment() {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "payment";
    }
}
