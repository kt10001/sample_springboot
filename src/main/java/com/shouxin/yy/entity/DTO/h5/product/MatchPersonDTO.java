package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/18 4:50 下午
 * @Author feikong
 */
@Data
public class MatchPersonDTO {

    @NotNull(message = "客户名称 参数错误")
    private String name;

    @NotNull(message = "金额 参数错误")
    private String amount;

    @NotNull(message = "年龄 参数错误")
    private String age;
    private String ageMin;
    private String ageMax;

    @NotNull(message = "借款人居住地 参数错误")
    private String area;

    private String income;

    private String isDue;
    private String loanAmount;
    private String loanUse;
    private String m6DueTimes;
    private String m12DueTimes;
    private String m24DueTimes;
    private String m6DueDays;
    private String m12DueDays;
    private String m24DueDays;
    private String m3QueryTimes;
    private String m6QueryTimes;
    private String m12QueryTimes;
    private String m24QueryTimes;

}
