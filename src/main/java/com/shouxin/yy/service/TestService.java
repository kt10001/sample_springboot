package com.shouxin.yy.service;

/**
 * @author feikong
 * @time 2023/9/7 4:56 下午
 */
public interface TestService {
    /**
     * test redis set功能
     * @param key
     * @param value
     */
    void testRedisSet(String key, String value);
}
