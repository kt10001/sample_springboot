package com.shouxin.yy.entity.PO;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @time 2022/7/18 7:32 下午
 * @Author feikong
 */
@Data
public class WxTemplateMsg {
    /**
     * 接收者openid
     */
    private String touser;
    /**
     * 模板ID
     */
    private String template_id;
    /**
     * 模板跳转链接
     */
    private String url;
    /**
     * 模板数据
     * {
     *                    "first": {
     *                        "value":"恭喜你购买成功！",
     *                        "color":"#123123"
     *                    },
     *                    "keyword1":{
     *                        "value":"巧克力",
     *                        "color":"#123123"
     *                    },
     *                    "keyword2": {
     *                        "value":"39.8元",
     *                        "color":"#173177"
     *                    },
     *                    "keyword3": {
     *                        "value":"2014年9月22日",
     *                        "color":"#173177"
     *                    },
     *                    "remark":{
     *                        "value":"欢迎再次购买！",
     *                        "color":"#173177"
     *                    }
     *            }
     */
    private JSONObject data;
}
