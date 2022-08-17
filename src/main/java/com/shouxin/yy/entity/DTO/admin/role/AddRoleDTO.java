package com.shouxin.yy.entity.DTO.admin.role;

import com.shouxin.yy.entity.VO.PermissionVO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class AddRoleDTO {

    @NotNull(message = "角色名称参数错误")
    private String name;

    private List<PermissionVO> permissions;
}
