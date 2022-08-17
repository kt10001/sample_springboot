package com.shouxin.yy.entity.DTO.h5.pay;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/23 2:05 下午
 * @Author feikong
 */
@Data
public class ContractDTO {

    @NotNull(message = "身份证人像面 参数错误")
    private String identFrontBase64;
    @NotNull(message = "身份证国徽面 参数错误")
    private String identBackBase64;
}
