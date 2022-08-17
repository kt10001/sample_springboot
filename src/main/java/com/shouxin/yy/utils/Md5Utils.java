package com.shouxin.yy.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5跑龙套
 *
 * @time 2021/8/25 10:23 上午
 * @Author feikong
 * @date 2022/02/17
 */
@Slf4j
public class Md5Utils {

    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes(StandardCharsets.UTF_8));
            // 使用指定的字节更新摘要
            byte[] b = md.digest();
            // 获得密文
            return byte2Hex(b);
        } catch (Exception e) {
            log.error("md5加密失败: {}", e.toString());
        }
        return "";
    }

    private static String byte2Hex(byte[] b) {
        int byteSize = b.length;
        // 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuilder sb = new StringBuilder(byteSize * 2);
        for (int j : b) {
            int tempInt = j;
            while (tempInt < 0) {
                // 把负数转换为正数
                tempInt = tempInt + 256;
            }
            if (tempInt < 16) {
                // 小于0F的数需要在前面补0
                sb.append("0");
            }
            sb.append(Integer.toString(tempInt, 16));
        }
        return sb.toString().toUpperCase();
    }

    public static String getMd5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            log.error("md5 hash 失败: {}", e.toString());
        }
        return "";
    }

    public static String getMd5Salt(String s) {
        s = s + "dingjunshan";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            log.error("md5 hash 失败: {}", e.toString());
        }
        return "";
    }

    public static String toHexString(byte[] b) {
        StringBuilder buffer = new StringBuilder();
        for (byte ts : b) {
            String hex = Integer.toHexString(ts & 0xff);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            buffer.append(hex);
        }
        return buffer.toString();
    }
}
