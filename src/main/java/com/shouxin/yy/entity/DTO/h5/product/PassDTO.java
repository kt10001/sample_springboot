package com.shouxin.yy.entity.DTO.h5.product;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 接口文档 https://buershujv.yuque.com/wtbggi/labw1l/fluykl#kjCsw
 * @time 2022/5/20 11:33 上午
 * @Author feikong
 */
@Data
public class PassDTO {

    @NotEmpty(message = "产品id 参数错误")
    private List<String> uuids;
    @NotNull(message = "客户名称 参数错误")
    private String name;
    @NotNull(message = "客户年龄 参数错误")
    private String age;
    private String ageMin;
    private String ageMax;

    private String isDue;
    private String loanAmount;
    private String loanUse;
    private String m6DueTimes;
    private String m12DueTimes;
    private String m24DueTimes;
    private String m6QueryTimes;
    private String m12QueryTimes;
    private String m24QueryTimes;
    private String taxTime;
    private String isTaxQj;
    private String taxQjNum;
    private String taxM12JsMoney;
    private String taxLevel;
    private String taxKp;
    private String taxM12KpMoney;
}
