package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/6/2 2:53 下午
 * @Author xingxing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryMonthVO {

    private Integer total;
    private BigDecimal amountTotal;
    private List<EntryMonthVO.EntryMonth> list;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EntryMonth {
        private String logo;
        private String productName;
        private String bankcard;
        private String time;
        private BigDecimal amount;
        private Integer type;
    }
}
