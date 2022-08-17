package com.shouxin.yy.entity.DTO.admin.product;

import com.alibaba.fastjson.JSONArray;
import com.shouxin.yy.entity.DO.ProductMsgDO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/13 11:27 上午
 * @Author feikong
 */
@Data
public class UpdateDetailDTO {

    @NotNull(message = "产品uuid错误")
    private String productUuid;

    private List<String> area;

    private List<ProductMsgDO> msg;

    private JSONArray content;
}
