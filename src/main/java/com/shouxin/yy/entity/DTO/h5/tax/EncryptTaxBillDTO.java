package com.shouxin.yy.entity.DTO.h5.tax;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wubaochun
 */
@Data
public class EncryptTaxBillDTO {

    @NotNull(message = "名称参数错误")
    private String name;

    @NotNull(message = "统一社会信用代码参数错误")
    private String licenseNum;

}
