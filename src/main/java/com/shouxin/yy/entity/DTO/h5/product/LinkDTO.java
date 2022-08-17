package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/6/2 11:57 上午
 * @Author xingxing
 */
@Data
public class LinkDTO {

    private Boolean isLoan;

    @NotNull(message = "linkPrefix 参数错误")
    private String linkPrefix;

    @NotNull(message = "managerUuid 参数错误")
    private String managerUuid;

    @NotNull(message = "productUuidList 参数错误")
    private List<String> productUuidList;
}
