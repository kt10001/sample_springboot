package com.shouxin.yy.entity.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class ConfigValueDTO {

    @NotNull(message = "配置名称参数错误")
    private String configKey;
}
