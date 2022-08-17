package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @time 2022/4/26 4:25 下午
 * @Author feikong
 */
@Data
public class LoginDTO {

    @NotBlank(message = "账号不能为空")
    @Length(min = 2, max = 30)
    private String account;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20)
    private String password;

    @NotBlank(message = "图形验证码不能为空")
    private String code;
}
