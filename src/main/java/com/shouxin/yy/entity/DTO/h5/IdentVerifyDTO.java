package com.shouxin.yy.entity.DTO.h5;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/11 8:10 下午
 * @Author feikong
 */
@Data
public class IdentVerifyDTO {

    @NotNull(message = "姓名参数错误")
    private String name;

    @NotNull(message = "身份证参数错误")
    private String identNumber;

    @NotNull(message = "短信验证码参数错误")
    private String code;
}
