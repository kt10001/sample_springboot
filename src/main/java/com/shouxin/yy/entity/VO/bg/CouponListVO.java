package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author xingxing
 * @since 2022-07-18
 */
@Data
public class CouponListVO {

    /**
     * 客户经理现金卷关联表id
     */
    private Integer id;

    /**
     * 现金券uuid
     */
    private String couponUuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;

    /**
     * 状态 0未使用 1使用
     */
    private Integer status;

    /**
     * 面额
     */
    private BigDecimal money;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;


}
