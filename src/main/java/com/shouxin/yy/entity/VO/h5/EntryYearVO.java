package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/7/14 10:53
 * @Author xingxing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryYearVO {

    private Integer total;
    private BigDecimal amountTotal;
    private List<EntryYearVO.EntryYear> list;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EntryYear {
        private String time;
        private BigDecimal amount;
    }
}
