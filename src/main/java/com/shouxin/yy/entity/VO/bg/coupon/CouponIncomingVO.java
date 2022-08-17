package com.shouxin.yy.entity.VO.bg.coupon;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class CouponIncomingVO {

    /**
     * 客户经理名称
     */
    private String name;
    /**
     * 客户经理uuid
     */
    private String uuid;
    /**
     * 领取方式 0-后台赠送
     */
    private String getType;
    /**
     * 领取时间
     */
    private String createAt;
    /**
     * 现金券状态 0-待使用 1-即将过期 2-已使用 3-已失效
     */
    private Integer status;
    /**
     * 使用时间
     */
    private String useTime;
    /**
     * 进件uuid
     */
    private String incomingUuid;
}
