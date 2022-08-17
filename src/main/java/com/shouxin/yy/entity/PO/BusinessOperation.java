package com.shouxin.yy.entity.PO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusinessOperation {

    /**
     * uuid
     */
    private String uuid;
    /**
     * 结算uuid
     */
    private String settlementUuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;

    /**
     * 业务进度 0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过
     */
    private Integer progress;
    /**
     * 授信金额
     */
    private BigDecimal creditAmount;
    /**
     * 放款金额
     */
    private BigDecimal loanAmount;
    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;
    /**
     * 备注(失败原因)
     */
    private String remarks;

    /**
     * 客户名称
     */
    private String unUserName;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算
     */
    private Integer settlementType;
    /**
     * 返佣方式
     * 0 - 按比例
     * 1 - 按金额
     */
    private Integer incomeType;
    /**
     * 会员返佣比例
     */
    private BigDecimal vipARate;
    private BigDecimal vipBRate;
    /**
     * 会员返佣金额
     */
    private BigDecimal vipAM;
    private BigDecimal vipBM;
    /**
     * 产品uuid
     */
    private String productUuid;

    /**
     * id(客户经理)
     */
    private Integer id;
    /**
     * 业务进度 0-已申请 1-授信中  2-授信通过 3-审批未通过 4-已提款 5-待审核 6-审核不通过 7-审核已通过
     */
    private Integer settlementProgress;
    /**
     * 结算状态 0-未结算 1-已结算
     */
    private Integer settlementStatus;
    /**
     * 授信金额(二次放款结算用到)
     */
    private BigDecimal creditAmountOld;
    /**
     * 三方放款id
     */
    private String thirdLoanId;


}
