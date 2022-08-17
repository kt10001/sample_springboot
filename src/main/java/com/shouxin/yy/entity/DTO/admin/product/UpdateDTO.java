package com.shouxin.yy.entity.DTO.admin.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/5/13 9:34 上午
 * @Author feikong
 */
@Data
public class UpdateDTO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;

    /**
     * 机构
     */
    private String company;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 额度
     */
    private Integer amount;
    /**
     * logo
     */
    private String logo;
    /**
     * 还款方式 0-等额本息 1-等额本金 2-等本等息 3-先息后本
     */
    private List<String> repayType;
    /**
     * 结算方式 0-授信结算 1-放款结算
     */
    private Integer billType;
    /**
     * 产品链接
     */
    private String link;
    /**
     * 返佣方式
     * 0 - 按比例
     * 1 - 按金额
     */
    private Integer incomeType;
    /**
     * 返佣比例
     */
    private BigDecimal incomeRate;
    /**
     * 会员返佣比例
     */
    private BigDecimal vipARate;
    private BigDecimal vipBRate;
    /**
     * 返佣金额
     */
    private BigDecimal incomeM;
    /**
     * 会员返佣金额
     */
    private BigDecimal vipAM;
    private BigDecimal vipBM;
    /**
     * 标签
     */
    private List<String> labels;
    /**
     * 出师奖
     */
    private BigDecimal levelARate;
    /**
     * 越级奖
     */
    private BigDecimal levelBRate;

    private List<String> rate;

    private List<String> loanMonth;
}
