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
public enum ProductTypeEnum {
    /**
     * 产品类型
     */
    SJD(0, "税金贷"),
    FPD(1, "发票贷"),
    JYD(2, "经营贷"),
    GDL(3,"个贷类"),
    CDD(4,"车抵贷"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link ProductTypeEnum } 实例
     **/
    public static ProductTypeEnum find(Integer code) {
        for (ProductTypeEnum instance : ProductTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}