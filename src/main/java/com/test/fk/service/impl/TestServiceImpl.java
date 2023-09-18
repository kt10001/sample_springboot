package com.test.fk.service.impl;

import com.test.fk.service.RedisService;
import com.test.fk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
