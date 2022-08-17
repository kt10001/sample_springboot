package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/17 4:08 下午
 * @Author feikong
 */
@Data
public class MatchProductVO {

    private String uuid;
    private String name;
    private String logo;
    private Integer amount;
    private Integer type;
    private List<String> rate;
    private List<String> repayType;
    private List<String> loanMonth;
    private List<String> rules;

    /**
     * 产品是否上架
     */
    private Boolean isFab = true;
}
