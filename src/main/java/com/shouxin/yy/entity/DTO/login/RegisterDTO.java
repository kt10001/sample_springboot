package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @time 2022/4/26 4:25 下午
 * @Author feikong
 */
@Data
public class RegisterDTO {

    @NotBlank(message = "用户名错误")
    @Length(min = 4, max = 40, message = "用户名长度需要在4到40之间")
    private String username;

    @NotBlank(message = "密码错误")
    @Length(min = 6, max = 20, message = "密码长度需要在6到20之间")
    private String password01;

    @NotBlank(message = "密码错误")
    @Length(min = 6, max = 20, message = "密码长度需要在6到20之间")
    private String password02;

    @Pattern(regexp = "^1\\d{10}$", message = "手机号错误")
    @NotBlank(message = "手机号错误")
    private String phone;

    @Pattern(regexp = ".+@.+", message = "邮箱错误")
    @NotBlank(message = "邮箱错误")
    private String email;
}
