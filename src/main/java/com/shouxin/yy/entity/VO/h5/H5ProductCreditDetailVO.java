package com.shouxin.yy.entity.VO.h5;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/26 18:54 下午
 * @Author xingxing
 */
@Data
public class H5ProductCreditDetailVO {

    private String uuid;
    private String name;
    private String image;
    private Integer billType;
    private String grade;
    private Integer type;
    private Integer status;
    /**
     * 机构
     */
    private String company;
    /**
     * 结算周期 0-日结
     */
    private Integer settlementPeriod;
    /**
     * 结算规则
     */
    private String settlementRules;
    private JSONArray content;
    private List<String> area;
    private Boolean isAreaAgree;
    private List<ProductVipVO> vips;
}
