package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 信用卡产品表(ProductCredit)实体类
 *
 * @author xingxing
 * @since 2022-05-17 18:00:00
 */
@Data
@TableName("product_credit")
public class ProductCreditDO{

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
     * 类型  5-信用卡
     */
    private Integer type;
    /**
     * 结算方式 0-首刷自动结算 1-核卡自动结算
     */
    private Integer billType;
    /**
     * 结算周期 0-日结
     */
    private Integer settlementPeriod;
    /**
     * 结算规则
     */
    private String settlementRules;
    /**
     * 产品链接
     */
    private String link;
    /**
     * 卡片等级
     */
    private String grade;
    /**
     * 返佣金额（普通会员）
     */
    private BigDecimal backMoneyOrd;
    /**
     * 返佣金额（超级会员）
     */
    private BigDecimal backMoneySup;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;
    /**
     * 是否删除 0-使用 1-删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;

}
