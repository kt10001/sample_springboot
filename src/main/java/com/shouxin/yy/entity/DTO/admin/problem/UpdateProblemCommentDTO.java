package com.shouxin.yy.entity.DTO.admin.problem;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author wubaochun
 */
@Data
public class UpdateProblemCommentDTO {

    /**
     * uuid
     */
    @NotNull(message = "uuid参数错误")
    private String uuid;

    /**
     * 备注
     */
    @NotNull(message = "备注参数错误")
    private String comment;

}
