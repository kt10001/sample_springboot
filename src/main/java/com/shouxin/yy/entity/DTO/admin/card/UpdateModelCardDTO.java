package com.shouxin.yy.entity.DTO.admin.card;

import com.shouxin.yy.entity.DO.ModelCardDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateModelCardDTO extends ModelCardDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
