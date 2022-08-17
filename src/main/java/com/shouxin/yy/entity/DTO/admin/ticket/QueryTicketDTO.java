package com.shouxin.yy.entity.DTO.admin.ticket;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @author wubaochun
 */
@Data
public class QueryTicketDTO extends PageDTO {

    /**
     * 显示状态 0-隐藏 1-显示
     */
    private Integer status;

    /**
     * 名称
     */
    private String name;

}
