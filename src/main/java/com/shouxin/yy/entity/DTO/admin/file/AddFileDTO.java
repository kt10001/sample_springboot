package com.shouxin.yy.entity.DTO.admin.file;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class AddFileDTO {

    @NotNull(message = "跳转链接错误")
    private String url;

    @NotNull(message = "名称参数错误")
    private String name;
}
