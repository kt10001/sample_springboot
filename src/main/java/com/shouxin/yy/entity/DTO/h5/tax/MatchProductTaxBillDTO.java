package com.shouxin.yy.entity.DTO.h5.tax;

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
public class MatchProductTaxBillDTO {

    @NotNull(message = "统一社会信用代码参数错误")
    private String licenseNum;

    @NotNull(message = "商家订单号参数错误")
    private String nonceStr;
}
