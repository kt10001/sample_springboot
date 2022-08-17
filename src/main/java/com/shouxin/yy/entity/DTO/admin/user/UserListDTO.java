package com.shouxin.yy.entity.DTO.admin.user;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class UserListDTO extends PageDTO {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;
}
