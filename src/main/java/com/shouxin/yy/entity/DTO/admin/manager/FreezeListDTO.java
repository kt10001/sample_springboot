package com.shouxin.yy.entity.DTO.admin.manager;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class FreezeListDTO extends PageDTO {

    /**
     * 客户经理名称
     */
    private String name;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 操作类型0冻结1解冻
     */
    private Integer type;
    /**
     * 排序值
     */
    private String sort;
    /**
     * 有值就降序
     */
    private String isDesc;

}
