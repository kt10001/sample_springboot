package com.shouxin.yy;

import cn.hutool.http.HttpUtil;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.net.SocketException;

/**
 * @author feikong
 * @time 2023/12/25 15:22
 */
@Service
public class ThirdPartyService {

    @Async
    @Retryable(
            value = { RestClientException.class, Exception.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 2)
    )
    public void callThirdPartyApi() {
        // 调用第三方API的逻辑
        // ...
        System.out.println("请求接口");
        System.out.println(System.currentTimeMillis());
        String result1= HttpUtil.get("https://www.baidu1.com");
        System.out.println(result1);
    }

    @Recover
    public void fallback() {
        // 降级处理逻辑
        // ...
        System.out.println("熔断");
        System.out.println(System.currentTimeMillis());
        String result1= HttpUtil.get("https://www.baidu.com");
        System.out.println("熔断结束");
    }
}
