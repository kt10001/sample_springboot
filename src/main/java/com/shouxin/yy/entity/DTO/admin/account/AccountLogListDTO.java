package com.shouxin.yy.entity.DTO.admin.account;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class AccountLogListDTO extends PageDTO {

    private String orderId;

    private String name;

    private Integer type;

    private String sort;

    private String isDesc;

    private String startTime;

    private String endTime;
}
