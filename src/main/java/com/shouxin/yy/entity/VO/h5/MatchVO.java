package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/19 11:22 上午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class MatchVO {

    private MatchUserVO user;

    private List<MatchProductVO> list;
}
