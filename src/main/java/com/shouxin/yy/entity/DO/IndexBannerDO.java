package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 首页banner(IndexBanner)实体类
 *
 * @author makejava
 * @since 2022-05-10 11:41:20
 */
@Data
@TableName("index_banner")
public class IndexBannerDO {
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
     * 链接
     */
    private String link;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 图片oss地址
     */
    private String ossUrl;
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

