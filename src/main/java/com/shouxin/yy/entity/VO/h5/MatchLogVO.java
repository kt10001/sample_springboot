package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

/**
 * @time 2022/5/19 3:01 下午
 * @Author feikong
 */
@Data
public class MatchLogVO {

    private String uuid;
    private String name;
    private String type;
    private String createAt;
    private Integer amount;
    private Integer num;

    private MatchVO detail;
}
