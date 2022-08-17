package com.shouxin.yy.entity.VO;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/12 8:46 下午
 * @Author feikong
 */
@Data
public class ProductVO {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;
    /**
     * 机构
     */
    private String company;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 额度
     */
    private Integer amount;
    /**
     * logo
     */
    private String logo;
    /**
     * 利率 多个利率,隔开
     */
    private List<String> rate;
    /**
     * 结算方式 0-授信结算 1-放款结算
     */
    private Integer billType;
    /**
     * 产品链接
     */
    private String link;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createAt;
}
