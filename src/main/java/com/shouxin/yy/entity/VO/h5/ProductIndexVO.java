package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @time 2022/5/5 1:45 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class ProductIndexVO {

    private Long total;
    private Map<String, Long> typeNum;
    private List<ProductListVO> list;
}
