package com.shouxin.yy.entity.DTO.vip;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/2 8:12 下午
 * @Author feikong
 */
@Data
public class CreateLevelDTO {

    /**
     * 会员等级
     */
    @NotNull(message = "等级 参数错误")
    private Integer level;

    /**
     * 名称
     */
    @NotBlank(message = "名称 参数错误")
    private String name;

    /**
     * 进件单数
     */
    private Integer incomeAmount = 0;
    /**
     * 团队人数
     */
    private Integer memberAmount = 0;
    /**
     * 会员人数
     */
    private Integer vipAmount = 0;


}
