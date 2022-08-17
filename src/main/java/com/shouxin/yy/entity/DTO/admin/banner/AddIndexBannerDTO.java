package com.shouxin.yy.entity.DTO.admin.banner;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @time 2022/5/10 11:56 上午
 * @Author feikong
 */
@Data
public class AddIndexBannerDTO {

    @NotNull(message = "oss地址错误")
    private String ossUrl;

    @NotNull(message = "名称参数错误")
    private String name;

    @NotNull(message = "排序值参数错误")
    @Min(value = 1, message = "排序值需要>=1")
    private Integer rankValue;

    private String link;

    @NotNull(message = "开始时间参数错误")
    @Pattern(regexp = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "开始时间格式错误")
    private String startTime;

    @NotNull(message = "结束时间参数错误")
    @Pattern(regexp = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "结束时间格式错误")
    private String endTime;


}
