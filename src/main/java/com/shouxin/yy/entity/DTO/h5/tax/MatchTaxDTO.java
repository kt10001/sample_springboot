package com.shouxin.yy.entity.DTO.h5.tax;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class MatchTaxDTO {

    /**
     * 近12个月申报经营收入
     */
    private String taxM12SbMoney;
    /**
     * 近12个月应税销售额
     */
    private String taxM12SqMoney;
    /**
     * 12月内纳税额缴纳总计
     */
    private String taxM12JsMoney;
    /**
     * 12月内开票金额总计
     */
    private String taxM12KpMoney;
    /**
     * 企业纳税欠缴次数
     */
    private String taxQjNum;
    /**
     * 连续开票时长
     */
    private String taxKp;
    /**
     * 近12月有效开票对象
     */
    private String taxKpIns;
    /**
     * 近12月有效开票月份
     */
    private String taxKpMonth;
    /**
     * 纳税评级限定等级
     */
    private String taxLevel;

}
