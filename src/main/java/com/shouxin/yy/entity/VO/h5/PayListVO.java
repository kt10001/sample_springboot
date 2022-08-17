package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/5/31 2:53 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class PayListVO {

    private String month;
    private List<Pays> pays;

    @Data
    @AllArgsConstructor
    public static class Pays {
        /**
         * 银行卡号
         */
        private String bankcard;
        /**
         * 提现时间
         */
        private String time;
        /**
         * 提现金额
         */
        private BigDecimal amount;
        /**
         * 提现状态
         */
        private String status;
        /**
         * 失败原因
         */
        private String reason;
    }
}
