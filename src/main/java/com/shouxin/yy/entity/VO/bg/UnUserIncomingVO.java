package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @time 2022/5/26 15:53 下午
 * @Author xingxing
 */
@Data
public class UnUserIncomingVO {
    /**
     * 客户名称
     */
    private String name;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 申请时间
     */
    private String createAt;
    /**
     * 进件单号
     */
    private String uuid;
    /**
     * 金额
     */
    private BigDecimal amount;

}
