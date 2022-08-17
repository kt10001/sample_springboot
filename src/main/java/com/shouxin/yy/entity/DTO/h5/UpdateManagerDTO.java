package com.shouxin.yy.entity.DTO.h5;

import com.shouxin.yy.entity.DO.ManagerDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/11 8:23 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateManagerDTO extends ManagerDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

    /**
     * 短信验证码
     */
    private String code;
}
