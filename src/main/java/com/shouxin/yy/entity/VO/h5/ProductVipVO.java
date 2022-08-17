package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

/**
 * @time 2022/5/18 1:56 下午
 * @Author feikong
 */
@Data
public class ProductVipVO {

    /**
     * 会员名称
     */
    private String name;
    /**
     * 返佣比例
     */
    private String rebate;
    /**
     * 佣金
     */
    private Integer reAmount;
}
