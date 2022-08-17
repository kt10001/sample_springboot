package com.shouxin.yy.entity.DTO.admin.copywriting;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @time 2022/6/10
 * @Author xingxing
 */
@Data
public class CopywritingListDTO extends PageDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * 文案类型
     */
    private Integer copywritingTypeId;

    /**
     * 状态
     */
    private Integer status;
}
