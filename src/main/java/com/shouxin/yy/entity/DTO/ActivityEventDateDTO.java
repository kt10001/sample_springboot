package com.shouxin.yy.entity.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author wubaochun
 */
@Data
public class ActivityEventDateDTO {

    @NotBlank(message = "日期不能为空")
    private String friendEventDate;
}
