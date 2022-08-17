package com.shouxin.yy.entity.VO;

import lombok.Data;


/**
 * @time 2021/5/17 18:49 下午
 * @Author xingxing
 */
@Data
public class ProductCreditVO {

    /**
     * uuid
     */
    private String uuid;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 名称
     */
    private String name;
    /**
     * 信用卡图片
     */
    private String image;
    /**
     * 机构
     */
    private String company;
    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;
    /**
     * 结算方式 0-首刷自动结算 1-核卡自动结算
     */
    private Integer billType;
    /**
     * 产品链接
     */
    private String link;
}
