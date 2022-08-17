package com.shouxin.yy.entity.DTO.admin.product;

import com.alibaba.fastjson.JSONArray;
import com.shouxin.yy.entity.DO.ProductMsgDO;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/13 11:27 上午
 * @Author feikong
 */
@Data
public class AddDetailDTO {

    @NotNull(message = "产品uuid错误")
    private String productUuid;

    @NotEmpty(message = "准入地区错误")
    private List<String> area;

    @NotEmpty(message = "产品动态错误")
    private List<ProductMsgDO> msg;

    private JSONArray content;
}
