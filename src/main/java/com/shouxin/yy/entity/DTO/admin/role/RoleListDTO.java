package com.shouxin.yy.entity.DTO.admin.role;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class RoleListDTO extends PageDTO {

    /**
     * 角色名称
     */
    private String name;
}
