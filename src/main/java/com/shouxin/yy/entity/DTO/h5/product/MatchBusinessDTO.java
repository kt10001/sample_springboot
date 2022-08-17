package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/18 4:50 下午
 * @Author feikong
 */
@Data
public class MatchBusinessDTO {

    @NotNull(message = "客户名称 参数错误")
    private String name;

    @NotNull(message = "金额 参数错误")
    private String amount;

    @NotNull(message = "年龄 参数错误")
    private String age;
    private String ageMin;
    private String ageMax;

    @NotNull(message = "企业所在地 参数错误")
    private String area;

    @NotNull(message = "借款人身份 参数错误")
    private String ident;
    private String share;
    private String bussAge;
    private String bussPersonNum;
    private String bussMoney;
    private String bussTrade;
    private String bussFrTime;
    private String taxTime;
    private String taxQjNum;
    private String taxM12JsMoney;
    private String taxM12YjMoney;
    private String taxLevel;
    private String taxKp;
    private String taxKpMonth;
    private String taxM12KpMoney;

}
