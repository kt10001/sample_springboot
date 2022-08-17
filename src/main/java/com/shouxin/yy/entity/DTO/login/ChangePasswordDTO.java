package com.shouxin.yy.entity.DTO.login;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChangePasswordDTO extends LoginDTO {

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20)
    private String password2;
}
