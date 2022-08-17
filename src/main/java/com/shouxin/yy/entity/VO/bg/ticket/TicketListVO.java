package com.shouxin.yy.entity.VO.bg.ticket;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class TicketListVO {

    /**
     * logo
     */
    private String logo;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 在线采票链接
     */
    private String onlineLink;
    /**
     * 税盘采集链接
     */
    private String taxLink;

}
