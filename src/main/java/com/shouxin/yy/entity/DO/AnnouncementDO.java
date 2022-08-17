package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 公告表(Announcement)实体类
 *
 * @author makejava
 * @since 2022-05-05 11:54:03
 */
@Data
@TableName("announcement")
public class AnnouncementDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 跳转链接
     */
    private String link;
    /**
     * 发布对象
     */
    private String receiver;

    /**
     * 发布者
     */
    private String faber;
    /**
     * 发布时间
     */
    private String fabTime;
    /**
     * 发布状态 0-未发布 1-已发布 2-已取消 3-发布失败
     */
    private Integer status;
    /**
     * 是否删除 0-否 1-是
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}

