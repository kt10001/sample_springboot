package com.shouxin.yy.entity.VO.bg.coupon;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class CouponManagerVO {

    /**
     * 客户经理名称
     */
    private String name;

    /**
     * 客户经理uuid
     */
    private String uuid;

    /**
     * 客户经理等级
     */
    private Integer managerLevel;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 团队人数
     */
    private Integer teamCount;
}
