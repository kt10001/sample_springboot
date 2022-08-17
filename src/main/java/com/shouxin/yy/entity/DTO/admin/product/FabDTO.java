package com.shouxin.yy.entity.DTO.admin.product;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/17 5:48 下午
 * @Author feikong
 */
@Data
public class FabDTO {

    @NotNull(message = "uuid 参数错误")
    private String uuid;

    @NotNull(message = "产品状态 参数错误")
    @Min(value = 0, message = "产品状态取值范围 0-1")
    @Max(value = 1, message = "产品状态取值范围 0-1")
    private Integer status;
}
