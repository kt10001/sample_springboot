package com.shouxin.yy.entity.DTO.wxPay;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class WxPayOrderDTO {

    @NotNull(message = "商品类型参数错误")
    private Integer type;

    private String time;
}
