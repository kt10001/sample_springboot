package com.shouxin.yy.entity.VO.bg.coupon;

import com.shouxin.yy.entity.DO.CouponDO;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class CouponDetailVO extends CouponDO {

    /**
     * 现金券客户经理列表
     */
    private List<CouponManagerVO> couponManagerVOS;

    /**
     * 现金券产品列表
     */
    private List<CouponProductVO> couponProductVOS;

    /**
     * 现金券数量列表
     */
    private List<CouponCountVO> couponCountVOS;
}
