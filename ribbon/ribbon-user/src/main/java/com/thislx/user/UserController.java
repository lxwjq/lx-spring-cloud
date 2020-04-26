package com.thislx.user;

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
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    private String orderService = "http://RIBBON-ORDER";


    /**
     * 获取自己模块的信息
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("user")
    public Map<String, String> getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "user");
        return map;
    }

    /**
     * 获取其他模块的信息（单节点）
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("order")
    public Map<String, String> getsignlePower() {
        Map<String, String> map = new HashMap<>();
        ResponseEntity<Object> forEntity = restTemplate
                .getForEntity(orderService + "/order", Object.class);
        map.put("result", forEntity.getBody().toString());
        return map;
    }
}
