package com.shouxin.yy.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/5 1:45 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class PageBaseVO<T> {

    private Long total;
    private List<T> list;
}
