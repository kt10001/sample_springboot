package com.shouxin.yy.entity.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class EmailDTO{

    @Email(message = "Email错误")
    @NotNull(message = "Email参数错误")
    private String email;
}