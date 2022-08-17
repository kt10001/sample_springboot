package com.shouxin.yy.entity.VO.bg;

import com.alibaba.fastjson.JSONArray;
import com.shouxin.yy.entity.DO.ProductMsgDO;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/16 11:17 上午
 * @Author feikong
 */
@Data
public class ProductDetailDetailVO {

    private String productUuid;
    private List<String> area;
    private List<ProductMsgDO> msg;
    private JSONArray content;
}
