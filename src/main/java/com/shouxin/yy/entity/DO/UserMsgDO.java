package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户通知表(UserMsg)实体类
 *
 * @author makejava
 * @since 2022-05-06 20:02:23
 */
@TableName("user_msg")
@Data
public class UserMsgDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户uuid
     */
    private String userUuid;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 链接
     */
    private String link;
    /**
     * 0-未读 1-已读
     */
    private Integer status;

    /**
     * 消息类型
     *
     */
    private Integer type;
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

