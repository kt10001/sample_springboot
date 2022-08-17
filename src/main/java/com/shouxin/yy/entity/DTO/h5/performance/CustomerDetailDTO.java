package com.shouxin.yy.entity.DTO.h5.performance;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class CustomerDetailDTO {

    @NotNull(message = "客户uuid参数错误")
    private String unUserUuid;

    private String managerUuid;

}
