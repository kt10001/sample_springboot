package com.shouxin.yy.entity.DTO.admin.coupon;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class UpdateCouponDTO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

    /**
     * 停止发券原因
     */
    private String noSendReason;
    /**
     * 失效原因
     */
    private String deletedReason;

    /**
     * 是否删除 0-否 1-是
     */
    private Integer isDeleted;

    /**
     * 发放状态 0-发放中 1-停止发放
     */
    private Integer sendType;

    /**
     * 产品列表
     */
    private List<String> productUuidList;
}
