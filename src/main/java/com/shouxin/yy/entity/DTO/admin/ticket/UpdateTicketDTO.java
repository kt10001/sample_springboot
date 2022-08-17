package com.shouxin.yy.entity.DTO.admin.ticket;

import com.shouxin.yy.entity.DO.CollectTicketDO;
import com.shouxin.yy.entity.VO.bg.coupon.CouponProductVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateTicketDTO extends CollectTicketDO {
    /**
     * 采票uuid
     */
    @NotNull(message = "uuid参数错误")
    private String uuid;

    /**
     * 产品列表
     */
    private List<CouponProductVO> productVOList;
}
