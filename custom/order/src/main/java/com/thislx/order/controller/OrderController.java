package com.thislx.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;


    /**
     * 获取自己模块的信息
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("order")
    public Map<String, String> getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "order");
        return map;
    }

    /**
     * 获取其他模块的信息（单节点）
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("signle/payment")
    public Map<String, String> getsignlePower() {
        Map<String, String> map = new HashMap<>();
        String forObject = restTemplate.getForObject("http://localhost:6002/payment", String.class);
        map.put("result", forObject);
        return map;
    }


    /**
     * 获取其他模块的信息（多节点）
     * 其中一个节点故障  无法进行故障转移
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("payment")
    public Map<String, String> getPower() {
        Map<String, String> map = new HashMap<>();
        String forEntity = restTemplate.getForObject("http://localhost/payment", String.class);
        map.put("result", forEntity);
        return map;
    }
}
