package com.shouxin.yy.entity.DTO.h5.pay;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @time 2022/7/4 2:55 下午
 * @Author feikong
 */
@Data
public class ApproveDTO {

    /**
     * 提现单号
     */
    @NotNull(message = "提现单号 参数错误")
    private String requestId;

    /**
     * 审批状态
     */
    @NotNull(message = "审批状态 参数错误")
    @Min(value = 1, message = "审批状态为 1/2")
    @Max(value = 2, message = "审批状态为 1/2")
    private Integer bgStatus;

    /**
     * 拒绝原因
     */
    private String reason;
}
