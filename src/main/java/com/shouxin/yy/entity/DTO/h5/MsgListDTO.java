package com.shouxin.yy.entity.DTO.h5;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/9 2:50 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgListDTO extends PageDTO {

    @NotNull(message = "消息类型参数错误")
    private Integer type;
}
