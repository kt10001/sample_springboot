package com.shouxin.yy.entity.DTO.h5.performance;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class FollowDTO {

    @NotNull(message = "客户uuid参数错误")
    private String unUserUuid;

    @NotNull(message = "跟进内容参数错误")
    private String comment;
}
