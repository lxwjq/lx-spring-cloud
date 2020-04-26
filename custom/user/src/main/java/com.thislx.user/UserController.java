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
    @GetMapping("signle/power")
    public Map<String, String> getsignlePower() {
        Map<String, String> map = new HashMap<>();
        ResponseEntity<Object> forEntity = restTemplate
                .getForEntity("http://localhost:6002/power", Object.class);
        map.put("result", forEntity.getBody().toString());
        return map;
    }


    /**
     * 获取其他模块的信息（多节点）
     *
     * @date 2020/4/21 14:06
     * @author lixiangx@leimingtech.com
     **/
    @GetMapping("power")
    public Map<String, String> getPower() {
        Map<String, String> map = new HashMap<>();
        ResponseEntity<Object> forEntity = restTemplate
                .getForEntity("http://localhost/power", Object.class);
        map.put("result", forEntity.getBody().toString());
        return map;
    }
}
