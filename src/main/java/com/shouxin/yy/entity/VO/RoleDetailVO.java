package com.shouxin.yy.entity.VO;

import com.shouxin.yy.entity.DO.RoleDO;
import lombok.Data;

import java.util.List;



/**
 * @author wubaochun
 */
@Data
public class RoleDetailVO extends RoleDO {

    private List<PermissionVO> permissions;
}
