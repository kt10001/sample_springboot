package com.shouxin.yy.entity.DTO.vip;

import com.shouxin.yy.entity.DO.LevelDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/5 10:01 上午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateLevelDTO extends LevelDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
