package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/18 11:57 上午
 * @Author feikong
 */
@Data
public class H5ProductDetailDTO {

    @NotNull(message = "uuid 参数错误")
    private String uuid;

    @NotNull(message = "地域 参数错误")
    private String area;
}
