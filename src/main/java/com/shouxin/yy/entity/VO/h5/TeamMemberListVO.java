package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author wubaochun
 */
@Data
public class TeamMemberListVO {

    private String managerUuid;

    private String managerName;

    private String pictureUrl;

    private String vipName;

    private String createAt;

    private BigDecimal incomeMoney;

    private Long incomeCount;

    private Long customerCount;

}
