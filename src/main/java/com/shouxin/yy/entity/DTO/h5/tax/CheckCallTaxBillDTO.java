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
public class CheckCallTaxBillDTO {

    @NotNull(message = "taxMsg参数错误")
    private String taxMsg;

    private Integer isEncrypt;
}
