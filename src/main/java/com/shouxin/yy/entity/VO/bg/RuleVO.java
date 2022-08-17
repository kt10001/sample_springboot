package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.util.List;

/**
 * 规则表(Rule)实体类
 *
 * @author makejava
 * @since 2022-05-16 16:16:52
 */
@Data
public class RuleVO {
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
    private List<String> defaultValue;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}

