package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @time 2022/5/31 11:53 上午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class BalanceVO {

    private BigDecimal income;
    private BigDecimal balance;
    private BigDecimal pay;
}
