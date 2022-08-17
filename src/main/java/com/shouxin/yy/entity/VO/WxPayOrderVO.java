package com.shouxin.yy.entity.VO;

import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class WxPayOrderVO {

    private String timeStamp;
    private String nonceStr;
    private String prepayId;
    private String paySign;
}
