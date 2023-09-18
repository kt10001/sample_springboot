package com.test.fk.controller;

import com.test.fk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time 2023/4/17 4:17 下午
 * @Author feikong
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/test")
    public String test(@RequestParam("key") String key,
                       @RequestParam("value") String value) {
        testService.testRedisSet(key, value);
        return "success";
    }
}
