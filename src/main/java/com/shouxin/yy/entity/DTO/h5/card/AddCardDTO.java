package com.shouxin.yy.entity.DTO.h5.card;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author wubaochun
 */
@Data
public class AddCardDTO {

    @NotNull(message = "名称参数错误")
    private String name;

    @NotNull(message = "身份参数错误")
    private String position;

    @Pattern(regexp = "^1\\d{10}$", message = "手机号错误")
    @NotNull(message = "手机号参数错误")
    private String phone;

    @NotNull(message = "微信号参数错误")
    private String wxId;

    @NotNull(message = "头像地址参数错误")
    private String pictureUrl;

    @NotNull(message = "二维码参数错误")
    private String code;

    @NotNull(message = "名片模版地址参数错误")
    private String tempCardUrl;

    @NotNull(message = "名片备注参数错误")
    private String comment;

}
