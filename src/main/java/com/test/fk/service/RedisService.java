package com.test.fk.service;

/**
 * @author feikong
 * @time 2023/9/7 4:54 下午
 */
public interface RedisService {
    /**
     * key 前缀
     */
    String REDIS_KEY_PREFIX = "test:key:";
    /**
     * 默认过期时间
     */
    int REDIS_KEY_EXPIRE = 120;

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}