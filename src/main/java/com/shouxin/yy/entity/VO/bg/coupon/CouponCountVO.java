package com.shouxin.yy.entity.VO.bg.coupon;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class CouponCountVO {

    /**
     * 现金券数量
     */
    private Integer count;

    /**
     * 现金券状态 0-待使用 1-即将过期 2-已使用 3-已失效
     */
    private Integer status;
}
