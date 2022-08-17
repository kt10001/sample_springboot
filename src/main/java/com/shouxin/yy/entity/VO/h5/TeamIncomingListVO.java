package com.shouxin.yy.entity.VO.h5;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class TeamIncomingListVO {

    private String productName;

    private String productUuid;

    private String logo;

    private String incomingTime;

    private Long incomeCount;

    private Integer rankValue;

    private Boolean isFab = true;

}
