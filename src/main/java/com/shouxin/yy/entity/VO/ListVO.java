package com.shouxin.yy.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/11 3:41 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class ListVO<T> {

    private List<T> result;
}
