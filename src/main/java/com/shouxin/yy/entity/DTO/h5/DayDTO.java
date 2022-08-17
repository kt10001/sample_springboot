package com.shouxin.yy.entity.DTO.h5;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author xingxing
 */
@Data
public class DayDTO {

    @NotNull(message = "时间参数错误")
    private String time;
}
