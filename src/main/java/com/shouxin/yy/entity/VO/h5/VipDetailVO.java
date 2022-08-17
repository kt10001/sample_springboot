package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@AllArgsConstructor
public class VipDetailVO {

    private String vipName;
    private String expireTime;
    private Integer status;
    private Integer type;
    private Integer priceM;
    private Integer priceHy;
    private Integer priceY;
    private String eventDate;

}
