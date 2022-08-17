package com.shouxin.yy.entity.DTO.admin.banner;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/26 2:32 下午
 * @Author feikong
 */
@Data
public class H5AdvertDTO {

    @NotNull(message = "类型 参数错误")
    private Integer type;
}
