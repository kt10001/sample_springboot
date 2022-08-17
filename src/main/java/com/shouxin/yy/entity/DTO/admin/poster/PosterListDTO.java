package com.shouxin.yy.entity.DTO.admin.poster;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @time 2022/6/9
 * @Author xingxing
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PosterListDTO extends PageDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * 海报类型
     */
    private Integer posterTypeId;

    /**
     * 状态
     */
    private Integer status;

}
