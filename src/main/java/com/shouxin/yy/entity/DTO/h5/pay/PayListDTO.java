package com.shouxin.yy.entity.DTO.h5.pay;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @time 2022/5/25 3:39 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PayListDTO extends PageDTO {

    /**
     * 客户经理名称
     */
    private String managerName;
    /**
     * 工猫单号
     */
    private String requestId;
    /**
     * 工猫 提现状态
     */
    private String status;
    /**
     * 后台 审批状态
     */
    private Integer bgStatus;
    private Integer isTimeSort = 0;
    private Integer isAmountSort = 0;
}
