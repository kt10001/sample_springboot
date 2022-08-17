package com.shouxin.yy.entity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @time 2022/4/26 5:51 下午
 * @Author feikong
 */
@Data
@ConfigurationProperties(prefix = "spring.redis")
@Component
public class RedisProperties {
    
    private String port;

    private String host;

    private String database;

    private String redisPassword;
}
