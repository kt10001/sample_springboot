package com.shouxin.yy.entity.DTO.h5.copywriting;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @time 2022/6/2 11:57 上午
 * @Author xingxing
 */
@Data
public class H5QueryCopywritingDTO extends PageDTO {


    /**
     * 搜索
     * */
    private String search;

    /**
     * 文案类型id
     * */
    private Integer copywritingTypeId;

    /**
     * 产品uuid
     * */
    private String productUuid;

}
