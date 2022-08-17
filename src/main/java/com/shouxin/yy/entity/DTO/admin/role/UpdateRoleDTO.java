package com.shouxin.yy.entity.DTO.admin.role;

import com.shouxin.yy.entity.DO.RoleDO;
import com.shouxin.yy.entity.VO.PermissionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateRoleDTO extends RoleDO {

    @NotNull(message = "角色uuid参数错误")
    private String uuid;

    private List<PermissionVO> permissions;
}
