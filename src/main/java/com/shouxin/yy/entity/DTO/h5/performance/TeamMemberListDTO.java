package com.shouxin.yy.entity.DTO.h5.performance;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class TeamMemberListDTO extends PageDTO {

    private String managerName;

    private String sort;

    private String isDesc;

    private List<String> managerUuidList;
}
