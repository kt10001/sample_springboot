package com.shouxin.yy.entity.DTO.admin.product.credit;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * @time 2022/5/18 10:00 上午
 * @Author xingxing
 */
@Data
public class AddCreditDTO {

    /**
     * 排序值
     */
    @NotNull(message = "信用卡产品排序值错误")
    @Min(value = 1, message = "产品排序值必须>=1")
    private Integer rankValue;
    /**
     * 名称
     */
    @NotNull(message = "信用卡产品名称错误")
    private String name;
    /**
     * 信用卡图片
     */
    @NotNull(message = "信用卡图片错误")
    private String image;
    /**
     * 机构
     */
    @NotNull(message = "信用卡产品机构错误")
    private String company;
    /**
     * 类型 5-信用卡
     */
    @NotNull(message = "信用卡产品类型错误")
    private Integer type;
    /**
     * 结算方式 0-首刷自动结算 1-核卡自动结算
     */
    @NotNull(message = "结算方式错误")
    private Integer billType;
    /**
     * 结算周期 0-日结
     */
    @NotNull(message = "结算周期错误")
    private Integer settlementPeriod;
    /**
     * 结算规则
     */
    @NotNull(message = "结算规则错误")
    private String settlementRules;
    /**
     * 产品链接
     */
    @NotNull(message = "信用卡产品链接错误")
    private String link;
    /**
     * 卡片等级
     */
    private String grade;
    /**
     * 返佣金额（普通会员）
     */
    @NotNull(message = "返佣金额错误")
    @Min(value = 1, message = "返佣金额值必须>=1")
    private BigDecimal backMoneyOrd;
    /**
     * 返佣金额（超级会员）
     */
    @NotNull(message = "返佣金额错误")
    @Min(value = 1, message = "返佣金额值必须>=1")
    private BigDecimal backMoneySup;
}
