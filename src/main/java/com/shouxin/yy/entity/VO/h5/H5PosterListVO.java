package com.shouxin.yy.entity.VO.h5;

import com.shouxin.yy.entity.VO.bg.PosterListVO;
import lombok.Data;

import java.util.List;


/**
 * @time 2022/6/14
 * @Author xingxing
 */
@Data
public class H5PosterListVO {

    private Integer id;
    private String name;
    private List<PosterListVO> poster;

}
