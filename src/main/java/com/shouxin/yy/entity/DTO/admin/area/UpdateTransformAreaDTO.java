package com.shouxin.yy.entity.DTO.admin.area;

import com.shouxin.yy.entity.DO.TransformAreaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateTransformAreaDTO extends TransformAreaDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
