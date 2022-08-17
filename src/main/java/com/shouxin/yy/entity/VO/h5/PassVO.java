package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/20 11:28 上午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class PassVO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 产品数量
     */
    private Integer num;

    /**
     * 查询产品列表
     */
    private List<PassProductVO> passList;

    /**
     * 其他产品列表
     */
    private List<ProductListVO> list;
}
