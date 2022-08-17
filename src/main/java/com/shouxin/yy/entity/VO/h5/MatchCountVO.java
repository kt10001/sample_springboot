package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @time 2022/5/5 1:45 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class MatchCountVO {

    /**
     * 总量
     */
    private Integer total;
    /**
     * 企业数量
     */
    private Integer busiNum;
    /**
     * 个人数量
     */
    private Integer psonNum;
}
