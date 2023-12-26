package com.shouxin.yy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time 2023/4/17 4:17 下午
 * @Author feikong
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {
    private final ThirdPartyService thirdPartyService;

    @GetMapping(value = "/test")
    public String test() {
        thirdPartyService.callThirdPartyApi();
        return "hello";
    }
}
