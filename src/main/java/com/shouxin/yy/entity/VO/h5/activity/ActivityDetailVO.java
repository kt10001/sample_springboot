package com.shouxin.yy.entity.VO.h5.activity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
@AllArgsConstructor
public class ActivityDetailVO {

    private Integer count;
    private List<ActivityManagerVO> list;
}
