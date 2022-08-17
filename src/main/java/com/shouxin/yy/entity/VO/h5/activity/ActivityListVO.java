package com.shouxin.yy.entity.VO.h5.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author wubaochun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityListVO {

    private String uuid;
    private Integer rank;
    private Integer count;
    private List<ActivityManagerCountVO> list;
}
