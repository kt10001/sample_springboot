package com.shouxin.yy.entity.DTO.admin.product.credit;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @time 2022/5/18 13:34 下午
 * @Author xingxing
 */
@Data
public class UpdateCreditDTO {

    /**
     * uuid
     */
    @NotNull(message = "uuid参数错误")
    private String uuid;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 名称
     */
    private String name;
    /**
     * 信用卡图片
     */
    private String image;
    /**
     * 机构
     */
    private String company;
    /**
     * 类型 5-信用卡
     */
    private Integer type;
    /**
     * 结算方式 0-首刷自动结算 1-核卡自动结算
     */
    private Integer billType;
    /**
     * 结算周期 0-日结
     */
    private Integer settlementPeriod;
    /**
     * 结算规则
     */
    private String settlementRules;
    /**
     * 产品链接
     */
    private String link;
    /**
     * 卡片等级
     */
    private String grade;
    /**
     * 返佣金额（普通会员）
     */
    private BigDecimal backMoneyOrd;
    /**
     * 返佣金额（超级会员）
     */
    private BigDecimal backMoneySup;
}
