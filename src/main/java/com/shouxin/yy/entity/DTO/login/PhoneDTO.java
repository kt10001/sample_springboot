package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @time 2022/5/11 4:06 下午
 * @Author feikong
 */
@Data
public class PhoneDTO {

    @Pattern(regexp = "^1\\d{10}$", message = "手机号错误")
    @NotBlank(message = "手机号错误")
    private String phone;
}
