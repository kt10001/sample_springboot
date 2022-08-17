package com.shouxin.yy.entity.DTO.h5.pay;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/7/4 2:55 下午
 * @Author feikong
 */
@Data
public class CommentDTO {

    /**
     * 提现单号
     */
    @NotNull(message = "提现单号 参数错误")
    private String requestId;

    /**
     * 备注
     */
    private String comment;
}
