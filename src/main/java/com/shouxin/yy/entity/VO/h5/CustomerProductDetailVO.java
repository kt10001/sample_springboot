package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wubaochun
 */
@Data
public class CustomerProductDetailVO {

    private String managerName;

    private String uuid;

    private String companyName;

    private String name;

    private String phone;

    private Integer progress;

    private String createAt;

    private String updateAt;

    private String productName;

    private String comment;

    private String settlementStatus;

    private String incomingUuid;

    private BigDecimal settlementAmount;

}
