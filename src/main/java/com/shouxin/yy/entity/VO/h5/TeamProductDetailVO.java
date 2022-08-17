package com.shouxin.yy.entity.VO.h5;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class TeamProductDetailVO {

    private String productName;

    private String productUuid;

    private String logo;

    private String incomingUuid;

    private Integer progress;

    private String incomingTime;

    private Boolean isFab = true;
}
