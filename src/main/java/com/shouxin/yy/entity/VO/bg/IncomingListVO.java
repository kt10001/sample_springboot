package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomingListVO {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品机构
     */
    private String productCompany;
    /**
     * 客户名称
     */
    private String unUserName;
    /**
     * 客户经理名称
     */
    private String managerName;
    /**
     * 产品类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡
     */
    private Integer productType;
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
     * 结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算
     */
    private Integer settlementType;
    /**
     * 结算状态 0-未结算 1-已结算
     */
    private Integer settlementStatus;
    /**
     * 客户uuid
     */
    private String unUserUuid;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
    /**
     * 申请时间
     */
    private String applyAt;
    /**
     * 授信时间
     */
    private String creditAt;
    /**
     * 放款时间
     */
    private String loanAt;
    /**
     * 结算时间
     */
    private String settlementAt;
    /**
     * 备注(失败原因)
     */
    private String remarks;
    /**
     * 结算uuid
     */
    private String settlementUuid;

}
