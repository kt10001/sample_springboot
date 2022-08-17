package com.shouxin.yy.entity.DTO.announcement;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/5 8:21 下午
 * @Author feikong
 */
@Data
public class CreateAnnouncementDTO {

    /**
     * 标题
     */
    @NotNull(message = "标题参数错误")
    private String title;

    /**
     * 发布对象
     */
    @NotEmpty(message = "发布对象参数错误")
    private List<String> receiver;

    /**
     * 发布时间
     */
    @NotNull(message = "发布时间参数错误")
    private String fabTime;

    /**
     * 链接
     */
    @NotNull(message = "链接参数错误")
    private String link;

    /**
     * 内容
     */
    @NotNull(message = "内容参数错误")
    private String content;
}
