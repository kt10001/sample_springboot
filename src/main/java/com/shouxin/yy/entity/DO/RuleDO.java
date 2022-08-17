package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 规则表(Rule)实体类
 *
 * @author makejava
 * @since 2022-05-16 16:16:52
 */
@Data
@TableName("rule")
public class RuleDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 类型 PERSON-个人 BUSINESS-企业 CREDIT-征信 TAX-税票
     */
    private String type;
    private String dataType;
    private String dataValue;
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

