package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@TableName("transform_area")
public class TransformAreaDO {
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
     * 名称
     */
    private String name;
    /**
     * 显示状态 0-隐藏 1-显示
     */
    private Integer status;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 跳转链接
     */
    private String link;
    /**
     * icon图片地址
     */
    private String iconUrl;
    /**
     * 角标图片地址
     */
    private String cornerUrl;
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

