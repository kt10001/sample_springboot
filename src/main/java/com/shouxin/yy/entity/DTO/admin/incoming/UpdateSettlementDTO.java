package com.shouxin.yy.entity.DTO.admin.incoming;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @time 2022/5/23 10:00 上午
 * @Author xingxing
 */
@Data
public class UpdateSettlementDTO {

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
     * 备注(失败原因)
     */
    private String remarks;
    /**
     * 三方放款id
     */
    private String thirdLoanId;

    /**
     * 只能后台调用标识
     */
    private Boolean flag;
}
