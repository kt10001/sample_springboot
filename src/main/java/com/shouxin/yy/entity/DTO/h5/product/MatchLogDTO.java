package com.shouxin.yy.entity.DTO.h5.product;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @time 2022/5/19 3:02 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MatchLogDTO extends PageDTO {

    private String type;
}
