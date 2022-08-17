package com.shouxin.yy.entity.DTO.admin.ticket;

import com.shouxin.yy.entity.VO.bg.coupon.CouponProductVO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class AddTicketDTO {

    /**
     * 显示状态 0-隐藏 1-显示
     */
    @NotNull(message = "显示状态错误")
    private Integer status;

    /**
     * 名称
     */
    @NotNull(message = "名称参数错误")
    private String name;

    /**
     * 在线采票链接
     */
    private String onlineLink;

    /**
     * 税盘采集链接
     */
    private String taxLink;

    /**
     * 产品列表
     */
    @NotNull(message = "产品列表参数错误")
    private List<CouponProductVO> productVOList;

}
