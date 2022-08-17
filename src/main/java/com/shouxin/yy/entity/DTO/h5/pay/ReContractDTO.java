package com.shouxin.yy.entity.DTO.h5.pay;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/23 2:05 下午
 * @Author feikong
 */
@Data
public class ReContractDTO {

    @NotNull(message = "手机验证码 参数错误")
    private String code;
    @NotNull(message = "合同id 参数错误")
    private String contractId;
}
