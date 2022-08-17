package com.shouxin.yy.entity.DTO.admin.coupon;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @author wubaochun
 */
@Data
public class ProductListDTO extends PageDTO {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;

    /**
     * 机构名称
     */
    private String company;

}
