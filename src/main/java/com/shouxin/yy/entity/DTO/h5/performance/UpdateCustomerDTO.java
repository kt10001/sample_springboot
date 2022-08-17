package com.shouxin.yy.entity.DTO.h5.performance;

import com.shouxin.yy.entity.DO.UnUserDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCustomerDTO extends UnUserDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
