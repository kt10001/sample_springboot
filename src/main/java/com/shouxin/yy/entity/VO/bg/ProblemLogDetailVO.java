package com.shouxin.yy.entity.VO.bg;

import com.shouxin.yy.entity.DO.ProblemLogDO;
import lombok.Data;

import java.util.List;

/**
 * @author wubaochun
 */
@Data
public class ProblemLogDetailVO extends ProblemLogDO {
    /**
     * 图片地址
     */
    private List<String> pictureUrlList;

}
