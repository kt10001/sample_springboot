package com.shouxin.yy.entity.DTO.h5;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class AddVipDTO {

    @NotNull(message = "状态参数错误")
    private Integer status;

    @NotNull(message = "商家订单号参数错误")
    private String nonceStr;

    @NotNull(message = "月份参数错误")
    private Integer months;
}
