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
public enum FabStatusEnum {
    /**
     * 发布状态
     */
    NOT_FAB(0, "未发布"),
    SUCCESS(1, "已发布"),
    CANCEL(2, "已取消"),
    FAIL(3,"发布失败"),
    PROCESSING(4,"发布中"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link FabStatusEnum } 实例
     **/
    public static FabStatusEnum find(String code) {
        for (FabStatusEnum instance : FabStatusEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}