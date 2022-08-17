package com.shouxin.yy.entity.VO.bg.ticket;

import com.shouxin.yy.entity.DO.CollectTicketDO;
import com.shouxin.yy.entity.VO.bg.coupon.CouponProductVO;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class TicketDetailVO extends CollectTicketDO {

    /**
     * 产品列表
     */
    private List<CouponProductVO> productVOList;

}
