package com.shouxin.yy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * spring shutdown hook
 * @time 2022/6/8 3:02 下午
 * @Author feikong
 */
@Slf4j
@Component
public class IDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean 已销毁...");
    }
}
