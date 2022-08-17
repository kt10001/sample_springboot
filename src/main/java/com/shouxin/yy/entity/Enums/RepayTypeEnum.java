package com.shouxin.yy.entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 发布状态
 * @time 2021/10/8 2:14 下午
 * @Author feikong
 */
@Getter
@AllArgsConstructor
public enum RepayTypeEnum {
    /**
     * 还款类型
     */
    SJD(0, "等额本息"),
    FPD(1, "等额本金"),
    JYD(2, "等本等息"),
    GDL(3,"先息后本"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link RepayTypeEnum } 实例
     **/
    public static RepayTypeEnum find(Integer code) {
        for (RepayTypeEnum instance : RepayTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}