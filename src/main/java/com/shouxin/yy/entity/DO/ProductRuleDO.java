package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品规则表(ProductRule)实体类
 *
 * @author makejava
 * @since 2022-05-17 10:14:18
 */
@Data
@TableName("product_rule")
public class ProductRuleDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 规则名称
     */
    private String name;
    /**
     * 规则编码
     */
    private String code;
    /**
     * 符号
     */
    private String symbol;
    /**
     * 值
     */
    private String value;
    /**
     * 默认值
     */
    private String defaultValue;
    /**
     * 类型 PERSON-个人 BUSINESS-企业 CREDIT-征信 TAX-税票
     */
    private String type;
    private String dataType;
    /**
     * 计算公式
     */
    private String expression;
    /**
     * 是否删除 0-否 1-是
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

