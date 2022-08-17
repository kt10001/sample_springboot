package com.shouxin.yy.entity.DTO.admin.rule;

import lombok.Data;

/**
 * @time 2022/5/16 4:14 下午
 * @Author feikong
 */
@Data
public class ListDTO {

    /**
     * 规则类型
     */
    private String type;
    /**
     * 规则名称
     */
    private String name;
    /**
     * 规则编码
     */
    private String code;
}
