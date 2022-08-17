package com.shouxin.yy.entity.VO.bg;

import com.shouxin.yy.entity.DO.ManagerDO;
import lombok.Data;

@Data
public class ManagerLevelVO extends ManagerDO {
    /**
     * 客户经理等级
     */
    private Integer level;
}
