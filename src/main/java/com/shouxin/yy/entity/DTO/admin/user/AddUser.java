package com.shouxin.yy.entity.DTO.admin.user;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class AddUser {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Email(message = "Email错误")
    private String email;

    @Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(16([0-9]))|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$"
            , message = "手机号错误")
    private String phone;

    @NotEmpty(message = "角色uuid列表不能为空")
    private List<String> roleUuidList;

}