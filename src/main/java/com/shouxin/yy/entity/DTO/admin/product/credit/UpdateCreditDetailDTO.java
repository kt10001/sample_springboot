package com.shouxin.yy.entity.DTO.admin.product.credit;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/18 15:00 下午
 * @Author xingxing
 */
@Data
public class UpdateCreditDetailDTO {

    @NotNull(message = "信用卡产品uuid错误")
    private String productCreditUuid;

    private List<String> area;

    private JSONArray content;
}
