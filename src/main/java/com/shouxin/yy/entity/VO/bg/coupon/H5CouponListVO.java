package com.shouxin.yy.entity.VO.bg.coupon;

import com.shouxin.yy.entity.DO.ManagerCouponDO;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class H5CouponListVO {

    /**
     * 待使用现金券
     */
    private List<ManagerCouponDO> beUserList;

    /**
     * 即将过去现金券
     */
    private List<ManagerCouponDO> beAboutUserList;

    /**
     * 已使用现金券
     */
    private List<ManagerCouponDO> usedList;

    /**
     * 已失效现金券
     */
    private List<ManagerCouponDO> unUserList;


}
