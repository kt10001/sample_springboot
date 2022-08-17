package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @time 2022/7/5 2:40 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class MsgCountVO {
    private Map<String, Long> nums;
}
