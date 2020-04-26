package com.thislx.power11;

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
public class PowerController {

    @GetMapping("power")
    public Map<String, String> getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "power11");
        return map;
    }
}
