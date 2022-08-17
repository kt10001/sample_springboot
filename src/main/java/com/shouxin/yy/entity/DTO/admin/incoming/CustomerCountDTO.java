package com.shouxin.yy.entity.DTO.admin.incoming;


import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class CustomerCountDTO {

    /**
     * managerUuid
     */
    private String managerUuid;

    /**
     * 时间
     */
    private String createAt;

    /**
     * 结算状态
     */
    private Integer settlementStatus;
}
