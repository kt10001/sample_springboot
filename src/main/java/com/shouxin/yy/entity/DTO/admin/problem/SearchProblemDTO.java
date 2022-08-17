package com.shouxin.yy.entity.DTO.admin.problem;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
public class SearchProblemDTO extends PageDTO {

    /**
     * 问题类型 0-系统bug 1-优化体验 2-功能操作 3-账号登录 4-其他问题 5-商务合作
     */
    private Integer type;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
