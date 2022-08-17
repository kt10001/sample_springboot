package com.shouxin.yy.entity.DTO.admin.product.credit;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @time 2022/5/17 4:00 下午
 * @Author xingxing
 */
@Data
public class ListCreditDTO extends PageDTO {

    /**
     * 信用卡产品名称
     */
    private String name;

    /**
     * 信用卡产品机构
     */
    private String company;
}
