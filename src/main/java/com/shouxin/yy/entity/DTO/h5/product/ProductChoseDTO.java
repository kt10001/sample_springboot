package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;

/**
 * @time 2022/5/19 5:48 下午
 * @Author feikong
 */
@Data
public class ProductChoseDTO {

    /**
     * 地区
     */
    private String area;
    /**
     * 法人变更发生时长
     */
    private String bussFrTime;
    /**
     * 借款人身份
     */
    private String ident;
    /**
     * 企业成立时长
     */
    private String bussAge;
    /**
     * 还款方式
     */
    private Integer repayType;
    /**
     * 结算方式
     */
    private Integer billType;
    /**
     * 是否看重征信查询
     */
    private Integer isQuery;
    /**
     * 是否看重征信逾期
     */
    private Integer isDue;
}
