package com.shouxin.yy.entity.DTO;

import lombok.Data;

/**
 * @time 2022/5/5 1:35 下午
 * @Author feikong
 */
@Data
public class PageDTO {

    private Integer pageNo = 1;

    private Integer pageSize = 10;
}
