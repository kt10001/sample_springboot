package com.shouxin.yy.entity.DTO.admin.card;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class AddModelCardDTO {

    @NotNull(message = "oss地址错误")
    private String ossUrl;

    @NotNull(message = "名称参数错误")
    private String name;

    @NotNull(message = "排序值参数错误")
    @Min(value = 1, message = "排序值需要>=1")
    private Integer rankValue;
}
