package com.shouxin.yy.entity.DTO.admin.user;

import com.shouxin.yy.entity.DO.UserDO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class UpdateUserDTO extends UserDO {

    @NotNull(message = "用户uuid参数错误")
    private String uuid;

    private List<String> roleUuidList;
}
