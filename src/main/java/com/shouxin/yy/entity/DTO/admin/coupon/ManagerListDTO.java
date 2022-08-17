package com.shouxin.yy.entity.DTO.admin.coupon;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @author wubaochun
 */
@Data
public class ManagerListDTO extends PageDTO {

    /**
     * 客户经理名称、uuid
     */
    private String value;

    /**
     * 客户经理等级
     */
    private Integer managerLevel;

    /**
     * 会员等级
     */
    private Integer level;

}
