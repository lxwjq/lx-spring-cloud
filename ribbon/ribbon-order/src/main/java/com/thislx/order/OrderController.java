package com.thislx.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiang
 * @version V1.0
 * @date 2020/4/19 18:17
 **/
@RestController
public class OrderController {

    @GetMapping("order")
    public Map<String, String> getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "order");
        return map;
    }
}
