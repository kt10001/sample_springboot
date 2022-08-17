package com.shouxin.yy.entity.DTO.h5.performance;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class TeamIncomingListDTO extends PageDTO {

    private String productName;

    private String sort;

    private String isDesc;

    private List<String> managerUuidList;
}
