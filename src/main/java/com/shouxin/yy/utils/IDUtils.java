package com.shouxin.yy.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 基于雪花算法的改进版 生成至少14位的long类型的自增全局唯一id
 */
public class IDUtils {

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1500000000000L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 5; // 序列号占用的位数
    private final static long MACHINE_BIT = 8; // 机器标识占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);

    private long sequence = 0L; // 序列号
    private long machineId; // 机器标识
    private long lastStmp = System.nanoTime();// 上一次时间戳

    private IDUtils(long machineId) {
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     */
    private synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            // 不同毫秒内，序列号置为0-9之间的随机数
            sequence = getRandomSequence();
        }

        lastStmp = currStmp;
        sequence = (sequence + machineId) << sequence;
        return (currStmp - START_STMP)// 时间戳部分
                | sequence; // 左移处理后的序列号
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.nanoTime();
    }

    private long getRandomSequence() {
        int min = 0;
        int max = 9;
        Random random = new Random();
        return (long) (random.nextInt(max) % (max - min + 1) + min);
    }

    /**
     *
     */
    public static long getGlobalId() {
        IDUtils globalId = new IDUtils(6);
        return globalId.nextId();
    }

    /**
     *
     */
    public static String nextStringId() {
        IDUtils globalId = new IDUtils(6);
        return String.valueOf(globalId.nextId());
    }

    /**
     * 获取32位随机数
     */
    public static String getUuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
