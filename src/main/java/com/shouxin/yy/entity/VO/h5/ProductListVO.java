package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/17 4:08 下午
 * @Author feikong
 */
@Data
public class ProductListVO {

    private String uuid;
    private String name;
    private String logo;
    private String msg;
    private Integer amount;
    private Integer income;
    private List<String> rate;
    private List<String> repayType;
    private List<String> loanMonth;
    /**
     * 标签
     */
    private List<String> labels;
    private Integer type;
    /**
     * 产品是否发布
     */
    private Boolean isFab = true;
}
