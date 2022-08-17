package com.shouxin.yy.entity.DTO.admin.product;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/5/12 4:11 下午
 * @Author feikong
 */
@Data
public class AddDTO {

    /**
     * 名称
     */
    @NotNull(message = "产品名称错误")
    private String name;
    /**
     * 全称
     */
    @NotNull(message = "产品原名错误")
    private String fullName;
    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    @NotNull(message = "产品类型错误")
    private Integer type;
    /**
     * 机构
     */
    @NotNull(message = "产品机构错误")
    private String company;
    /**
     * 排序值
     */
    @NotNull(message = "产品排序值错误")
    @Min(value = 1, message = "产品排序值必须>=1")
    private Integer rankValue;

    /**
     * 额度
     */
    @NotNull(message = "最大额度错误")
    private Integer amount;
    /**
     * logo
     */
    @NotNull(message = "logo错误")
    private String logo;
    /**
     * 利率 多个利率,隔开
     */
    @NotEmpty(message = "年化利率错误")
    private List<String> rate;
    /**
     * 还款方式 0-等额本息 1-等额本金 2-等本等息 3-先息后本
     */
    @NotNull(message = "还款方式错误")
    private List<String> repayType;
    /**
     * 贷款周期，多个周期,隔开
     */
    @NotEmpty(message = "贷款周期错误")
    private List<String> loanMonth;
    /**
     * 结算方式 0-授信结算 1-放款结算
     */
    @NotNull(message = "结算方式错误")
    private Integer billType;
    /**
     * 产品链接
     */
    @NotNull(message = "产品链接错误")
    private String link;
    /**
     * 返佣方式
     * 0 - 按比例
     * 1 - 按金额
     */
    @NotNull(message = "返佣方式 参数错误")
    @Min(value = 0, message = "返佣方式取值范围 0-1")
    @Max(value = 1, message = "返佣方式取值范围 0-1")
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
     * 出师奖
     */
    private BigDecimal levelARate = new BigDecimal(0);
    /**
     * 越级奖
     */
    private BigDecimal levelBRate = new BigDecimal(0);
    /**
     * 标签
     */
    private List<String> labels;
}
