package com.shouxin.yy.entity.DTO.wxPay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxRefundDTO {

    @NotNull(message = "商家订单号参数错误")
    private String outTradeNo;

    @NotNull(message = "价格参数错误")
    private Integer money;
}
