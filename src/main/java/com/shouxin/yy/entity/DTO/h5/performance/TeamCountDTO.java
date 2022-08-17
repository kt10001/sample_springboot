package com.shouxin.yy.entity.DTO.h5.performance;


import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class TeamCountDTO {

    /**
     * managerUuid
     */
    private List<String> managerUuidList;

    /**
     * 结算状态
     */
    private Integer settlementStatus;
}
