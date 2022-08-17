package com.shouxin.yy.entity.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/13 10:02 上午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UuidDTO extends PageDTO {

    @NotNull(message = "uuid参数错误")
    private String uuid;
}
