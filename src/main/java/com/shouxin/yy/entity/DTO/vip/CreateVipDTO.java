package com.shouxin.yy.entity.DTO.vip;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/2 8:12 下午
 * @Author feikong
 */
@Data
public class CreateVipDTO {

    /**
     * 会员等级
     */
    @NotNull(message = "会员等级参数错误")
    private Integer level;

    /**
     * 名称
     */
    @NotBlank(message = "名称参数错误")
    private String name;

    /**
     * 月卡金额
     */
    private Integer priceM = 0;
    /**
     * 半年卡金额
     */
    private Integer priceHy = 0;
    /**
     * 年卡金额
     */
    private Integer priceY = 0;


}
