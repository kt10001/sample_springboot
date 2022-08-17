package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @time 2022/5/25 3:37 下午
 * @Author feikong
 */
@Data
public class PayListVO {

    /**
     * 客户经理名称
     */
    private String managerName;
    /**
     * 客户经理ID
     */
    private String id;
    /**
     * 收款户名
     */
    private String name;
    /**
     * 银行账号
     */
    private String bankcard;
    /**
     * 身份证号
     */
    private String identNumber;
    /**
     * 申请时间
     */
    private String applyTime;
    /**
     * 提现金额
     */
    private BigDecimal amount;
    /**
     * 划付状态
     */
    private String status;
    /**
     * 审核状态
     */
    private Integer bgStatus;
    /**
     * 关联单号(工猫)
     */
    private String requestId;
    /**
     * 备注
     */
    private String comment;
}
