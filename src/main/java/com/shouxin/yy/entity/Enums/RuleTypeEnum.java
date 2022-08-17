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
public enum RuleTypeEnum {
    /**
     * 规则类型
     */
    STRING("STRING", "字符串类型"),
    SINGLE("SINGLE", "单选类型"),
    MULTIPLE("MULTIPLE", "多选类型"),
    ;

    /** 状态码 */
    private String code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link RuleTypeEnum } 实例
     **/
    public static RuleTypeEnum find(String code) {
        for (RuleTypeEnum instance : RuleTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}