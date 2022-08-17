package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author wubaochun
 */
@Data
public class TeamCountVO {

    private Integer teamCount;

    private Long incomingCount;

    private Long haveIncomeCount;

    private BigDecimal haveIncomeMoney;

}
