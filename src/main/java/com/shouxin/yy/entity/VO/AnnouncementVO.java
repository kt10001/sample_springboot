package com.shouxin.yy.entity.VO;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/12 5:45 下午
 * @Author feikong
 */
@Data
public class AnnouncementVO {

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
    private List<String> receiver;

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
     * 创建时间
     */
    private String createAt;
}
