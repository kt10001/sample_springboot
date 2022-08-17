package com.shouxin.yy.entity.DTO.h5;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/9 2:50 下午
 * @Author feikong
 */
@Data
public class MsgDetailDTO {

    @NotNull(message = "消息id参数错误")
    private Integer id;
}
