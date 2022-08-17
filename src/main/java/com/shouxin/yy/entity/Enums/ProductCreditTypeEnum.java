package com.shouxin.yy.entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @time 2022/5/30 2:14 下午
 * @Author xingxing
 */
@Getter
@AllArgsConstructor
public enum ProductCreditTypeEnum {

    /**
     * 产品类型
     */
    XYK(5, "信用卡"),
    ;
    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;
    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link ProductCreditTypeEnum } 实例
     **/
    public static ProductCreditTypeEnum find(Integer code) {
        for (ProductCreditTypeEnum instance : ProductCreditTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }

}
