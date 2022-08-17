package com.shouxin.yy.entity.DTO.admin.notice;

import lombok.Data;

/**
 *
 * @author xingxing
 * @since 2022-07-27
 */

@Data
public class UpdateNoticeTemplateDTO {
    /**
     * id
     */
    private Integer id;
    /**
     * 消息头
     */
    private String first;
    /**
     * 消息内容
     */
    private String context;
    /**
     * 消息尾
     */
    private String remark;
    /**
     * 跳转链接
     */
    private String url;
    /**
     * 状态  0禁用 1启用
     */
    private Integer status;
}
