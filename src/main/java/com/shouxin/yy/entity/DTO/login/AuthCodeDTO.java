package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author wubaochun
 */
@Data
public class AuthCodeDTO {

    @NotBlank(message = "账号不能为空")
    @Length(min = 2, max = 30)
    private String account;

}
