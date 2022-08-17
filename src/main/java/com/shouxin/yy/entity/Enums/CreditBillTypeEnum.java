package com.shouxin.yy.entity.Enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信用卡产品结算方式
 * @time 2022/5/18 10:10 上午
 * @Author xingxing
 */
@Getter
@AllArgsConstructor
public enum CreditBillTypeEnum {

    /**
     * 结算方式
     */
    FAS(0, "首刷自动结算"),
    CAS(1, "核卡自动结算"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link CreditBillTypeEnum } 实例
     **/
    public static CreditBillTypeEnum find(Integer code) {
        for (CreditBillTypeEnum instance : CreditBillTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}
