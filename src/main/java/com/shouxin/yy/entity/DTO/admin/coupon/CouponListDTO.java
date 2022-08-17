package com.shouxin.yy.entity.DTO.admin.coupon;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @author wubaochun
 */
@Data
public class CouponListDTO extends PageDTO {

    /**
     * 现金券名称
     */
    private String name;

    /**
     * 是否失效 0-否 1-是
     */
    private Integer isDeleted;
}
