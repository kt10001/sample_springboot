package com.shouxin.yy.entity.VO.bg.coupon;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class CouponProductVO {

    /**
     * 产品uuid
     */
    private String uuid;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品logo
     */
    private String logo;

    /**
     * 产品机构名称
     */
    private String company;

    /**
     * 产品类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;

    private Integer amount;
}
