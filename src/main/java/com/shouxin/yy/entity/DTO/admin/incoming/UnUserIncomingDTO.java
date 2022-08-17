package com.shouxin.yy.entity.DTO.admin.incoming;


import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @time 2022/5/26 10:00 上午
 * @Author xingxing
 */
@Data
public class UnUserIncomingDTO extends PageDTO {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户类型
     */
    private Integer type;

    // 0 从小到大 1从大到小
    //时间排序
    private Integer isTimeSort;
    //金额排序
    private Integer isAmountSort;


}
