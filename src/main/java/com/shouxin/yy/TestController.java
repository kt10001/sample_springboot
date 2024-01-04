package com.shouxin.yy;

import org.springframework.web.bind.annotation.*;

/**
 * test模块
 * @time 2023/4/17 4:17 下午
 * @Author feikong
 *
 */
@RestController
@RequestMapping("/mock")
public class TestController {

    /**
     * mock接口
     * @param url 接口url
     * @return
     */
    @GetMapping(value = "/{url}")
    public String test(@PathVariable("url") String url) {
        if ("aaa".equals(url)) {
            return "aaaaa";
        } else if("bbb".equals(url)) {
            return "bbbbb";
        }
        return "hello world";
    }

    /**
     * post接口
     * @param params 参数
     * @return hello
     */
    @PostMapping(value = "/post")
    public ApiResponse<Params> test(@RequestBody Params params) {
        return ApiResponse.success(params);
    }
}
