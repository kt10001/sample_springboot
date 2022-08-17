package com.shouxin.yy.entity.DTO.admin.file;

import com.shouxin.yy.entity.DO.FileDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateFileDTO extends FileDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
