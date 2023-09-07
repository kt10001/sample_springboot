package com.shouxin.yy.service.impl;

import com.shouxin.yy.service.RedisService;
import com.shouxin.yy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author feikong
 * @time 2023/9/7 4:56 下午
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private RedisService redisService;

    @Override
    public void testRedisSet(String key, String value) {
        redisService.set(RedisService.REDIS_KEY_PREFIX + key, value);
        redisService.expire(RedisService.REDIS_KEY_PREFIX + key, RedisService.REDIS_KEY_EXPIRE);
    }
}
