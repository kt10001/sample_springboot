package com.shouxin.yy.entity.DTO.admin.coupon;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wubaochun
 */
@Data
public class IncomingListDTO extends PageDTO {
    /**
     * 现金券uuid
     */
    @NotNull(message = "couponUuid参数错误")
    private String couponUuid;

    /**
     * 进件uuid
     */
    private String incomingUuid;

    /**
     * 使用状态 0-待使用 1-即将过期 2-已使用 3-已失效
     */
    private Integer status;

}
