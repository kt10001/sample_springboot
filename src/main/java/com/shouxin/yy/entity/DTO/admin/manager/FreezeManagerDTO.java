package com.shouxin.yy.entity.DTO.admin.manager;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class FreezeManagerDTO {

    /**
     * 客户经理名称
     */
    private String name;
    /**
     * 客户经理uuid
     */
    @NotNull(message = "客户经理uuid参数错误")
    private String managerUuid;
    /**
     * 0冻结1解冻
     */
    @NotNull(message = "状态参数错误")
    private Integer freeze;
    /**
     * 原因
     */
    @NotNull(message = "原因参数错误")
    private String reason;
}
