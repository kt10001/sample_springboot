package com.shouxin.yy.entity.DTO.admin.product.credit;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/18 14:27 下午
 * @Author xingxing
 */
@Data
public class AddCreditDetailDTO {

    @NotNull(message = "信用卡产品uuid错误")
    private String productCreditUuid;

    @NotEmpty(message = "准入地区错误")
    private List<String> area;

    private JSONArray content;
}
