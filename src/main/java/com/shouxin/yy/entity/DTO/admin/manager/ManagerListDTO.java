package com.shouxin.yy.entity.DTO.admin.manager;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class ManagerListDTO extends PageDTO {

    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 客户经理名称
     */
    private String name;
    /**
     * 会员等级
     */
    private Integer level;
    /**
     * 是否冻结0非冻结1冻结
     */
    @NotNull(message = "冻结参数错误")
    private Integer isDeleted;
    /**
     * 排序参数
     */
    private String sort;
    /**
     * 有值就降序
     */
    private String isDesc;
}
