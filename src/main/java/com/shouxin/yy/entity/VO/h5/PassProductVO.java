package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/20 11:28 上午
 * @Author feikong
 */
@Data
public class PassProductVO {

    private String uuid;
    private String name;
    private String logo;
    private Integer amount;
    private Integer income;
    private Integer star;
    private List<String> advices;
    /**
     * 产品是否发布
     */
    private Boolean isFab = true;
}
