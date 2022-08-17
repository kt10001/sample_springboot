package com.shouxin.yy.entity.PO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SettlementList {

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
     * 结算uuid
     */
    private String settlementUuid;

}
