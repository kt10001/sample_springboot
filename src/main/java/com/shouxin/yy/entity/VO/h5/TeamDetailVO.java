package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class TeamDetailVO {

    private String managerUuid;

    private String pictureUrl;

    private String name;

    private String phone;

    private String vipName;

    private String createAt;

    private Long customerCount;

    private Long incomeCount;

    private BigDecimal incomeMoney;

    private List<TeamProductDetailVO> incomingLog;
}
