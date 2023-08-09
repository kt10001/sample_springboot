package com.shouxin.yy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time 2023/4/17 4:17 下午
 * @Author feikong
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "hello world";
    }
}
