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
public enum BillTypeEnum {
    /**
     * 结算方式
     */
    SJD(0, "授信结算"),
    FPD(1, "放款结算"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link BillTypeEnum } 实例
     **/
    public static BillTypeEnum find(Integer code) {
        for (BillTypeEnum instance : BillTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}