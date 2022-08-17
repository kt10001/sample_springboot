package com.shouxin.yy.entity.DTO.admin.product;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @time 2022/5/12 4:11 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListDTO extends PageDTO {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡
     */
    private Integer type;
    private Integer isAmountSort;
    private Integer isRateSort;
    private Integer isTimeSort;
    private Integer isRankSort;
    private Integer isIncomeSort;

    private String area;

    private List<String> productUuidList;

}
