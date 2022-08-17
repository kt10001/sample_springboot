package com.shouxin.yy.entity.VO.h5;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @time 2022/5/20 3:41 下午
 * @Author feikong
 */
@Data
public class PassLogVO {

    private String name;
    private JSONArray pass;
    private String createAt;
    private Integer num;
    private PassVO detail;
}
