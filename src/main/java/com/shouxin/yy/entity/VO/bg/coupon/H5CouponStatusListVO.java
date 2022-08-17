package com.shouxin.yy.entity.VO.bg.coupon;

import com.shouxin.yy.entity.DO.ManagerCouponDO;
import lombok.Data;

import java.util.List;

/**
 * @author wubaochun
 */
@Data
public class H5CouponStatusListVO {

    /**
     * 0待领取1已领取
     */
    private Integer status;

    /**
     * 现金券列表
     */
    private List<ManagerCouponDO> couponDOList;

}
