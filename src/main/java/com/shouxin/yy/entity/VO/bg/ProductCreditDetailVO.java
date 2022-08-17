package com.shouxin.yy.entity.VO.bg;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/18 16:17 下午
 * @Author xingxing
 */
@Data
public class ProductCreditDetailVO {

    private String productCreditUuid;
    private List<String> area;
    private JSONArray content;
}
