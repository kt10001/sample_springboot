package com.shouxin.yy.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @time 2021/8/13 11:36 上午
 * @Author feikong
 */
public class GenIdUtil {

    /**
     * 生成订单号
     * 99ke+当前10位时间戳+4位随机数字
     * @return orderId
     */
    public static String genOrderId(){
        long nowTimestamp =  System.currentTimeMillis();
        return String.format("%s%s%s", "99ke", nowTimestamp, RandomUtil.randomNumbers(4));
    }

    /**
     * 生成客户经理编号id
     * 规则 99 + 4位时间戳 + 2位随机数字
     * @return {@code String}
     */
    public static String genManagerId() {
        long nowTimestamp =  System.currentTimeMillis();
        String time = String.valueOf(nowTimestamp);
        return String.format("%s%s%s", "99", time.substring(time.length()-4), RandomUtil.randomNumbers(2));
    }

    public static String genManagerIdPlus() {
        long nowTimestamp =  System.currentTimeMillis();
        String time = String.valueOf(nowTimestamp);
        return String.format("%s%s%s", "99", time.substring(time.length()-4), RandomUtil.randomNumbers(3));
    }

    /**
     * 获取随机数生成器对象<br>
     * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
     *
     * @return {@link ThreadLocalRandom}
     * @since 3.1.2
     */
    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获得指定范围内的随机数 [0,limit)
     *
     * @param limit 限制随机数的范围，不包括这个数
     * @return 随机数
     */
    public static int randomInt(int limit) {
        return getRandom().nextInt(limit);
    }

    /**
     * 获得指定范围内的随机数 [0,limit)
     *
     * @param limit 限制随机数的范围，不包括这个数
     * @return 随机数
     */
    public static String randomStr(int limit) {
        return Integer.toString(getRandom().nextInt(limit));
    }

    /**
     * 生成进件单号
     * 规则 时间戳 + 2位随机数
     * @return {@code String}
     */
    public static String incomingId() {
        long nowTimestamp =  System.currentTimeMillis();
        String time = String.valueOf(nowTimestamp);
        return String.format("%s%s", time, RandomUtil.randomNumbers(2));
    }
}
