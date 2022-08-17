package com.shouxin.yy.entity.DTO.h5.coupon;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class ProductCouponDTO extends PageDTO {

    @NotNull(message = "uuid参数错误")
    private String uuid;
}
