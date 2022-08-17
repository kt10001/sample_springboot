package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @time 2022/5/11 4:26 下午
 * @Author feikong
 */
@Data
public class H5LoginDTO {

    @Pattern(regexp = "^1\\d{10}$", message = "手机号错误")
    @NotBlank(message = "手机号错误")
    private String phone;

    @NotNull(message = "短信验证码错误")
    private String code;

    /**
     * 上级客户经理uuid
     */
    private String managerUuid;

    /**
     * 微信code
     */
    private String wxCode;
}
