package com.shouxin.yy.entity.DTO.h5.search;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/26 6:02 下午
 * @Author feikong
 */
@Data
public class SearchProductDTO {

    @NotNull(message = "产品名称 参数错误")
    private String name;

}
