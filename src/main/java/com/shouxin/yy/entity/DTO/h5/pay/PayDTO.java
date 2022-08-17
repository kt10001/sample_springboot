package com.shouxin.yy.entity.DTO.h5.pay;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @time 2022/5/23 2:05 下午
 * @Author feikong
 */
@Data
public class PayDTO {

    @NotNull(message = "提现金额 参数错误")
    private BigDecimal amount;
    @NotNull(message = "银行卡 参数错误")
    private String bankcard;
}
