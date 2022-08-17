package com.shouxin.yy.entity.DTO.h5.card;

import com.shouxin.yy.entity.DO.CardDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCardDTO extends CardDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
