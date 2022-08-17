package com.shouxin.yy.entity.DTO.admin.area;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class AddTransformAreaDTO {

    @NotNull(message = "显示状态错误")
    private Integer status;

    @NotNull(message = "名称参数错误")
    private String name;

    @NotNull(message = "跳转链接参数错误")
    private String link;

    @NotNull(message = "icon图片地址参数错误")
    private String iconUrl;

    @NotNull(message = "角标图片地址参数错误")
    private String cornerUrl;

    @NotNull(message = "排序值参数错误")
    @Min(value = 1, message = "排序值需要>=1")
    private Integer rankValue;
}
