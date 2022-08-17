package com.shouxin.yy.entity.DTO.h5.performance;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;



/**
 * @author wubaochun
 */
@Data
public class CustomerListDTO extends PageDTO {

    private Integer unUserType;

    private String sort;

    private String isDesc;

    private String managerUuid;

}
