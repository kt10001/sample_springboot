package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 公众号模板表表(noticeTemplate)实体类
 *
 * @author xingxing
 * @since 2022-07-20
 */
@Data
@TableName("notice_template")
public class NoticeTemplateDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 模板标题
     */
    private String title;
    /**
     * 模板id
     */
    private String templateId;
    /**
     * 模板类型
     */
    private String type;
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
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}
