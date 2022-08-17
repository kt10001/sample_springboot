package com.shouxin.yy.entity.DTO.admin.incoming;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/24 10:00 上午
 * @Author xingxing
 */
@Data
public class AddIncomingDTO {
    /**
     * 客户经理uuid
     */
    @NotNull(message = "managerUuid参数错误")
    private String managerUuid;

    /**
     * 产品uuid
     */
    @NotNull(message = "productUuid参数错误")
    private String productUuid;

    /**
     * 姓名
     */
    @NotNull(message = "name参数错误")
    private String name;

    /**
     * 产品类型
     */
    @NotNull(message = "productType参数错误")
    private String productType;

    /**
     * 机构名称
     */
    private String companyName;

    /**
     * 用户手机号
     */
    @NotNull(message = "phone参数错误")
    private String phone;

    /**
     * 用户身份证号
     */
    @NotNull(message = "idNo参数错误")
    private String idNo;

}
