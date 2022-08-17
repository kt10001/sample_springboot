package com.shouxin.yy.entity.PO;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @time 2022/3/22 4:41 下午
 * @Author feikong
 */
@Data
public class ShouWeiResponse {
    private String resp_code;
    private String resp_msg;
    private String resp_order;
    private String timestamp;
    private JSONObject resp_data;
}
