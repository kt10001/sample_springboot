package com.shouxin.yy.entity.DTO.admin.notice;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @time 2022/7/20 15:00
 * @Author xingxing
 */
@Data
public class ListNoticeDTO extends PageDTO {
    /**
     * 模板标题
     */
    private String title;
    /**
     * 模板类型
     */
    private String type;
    /**
     * 状态
     */
    private Integer status;
}
