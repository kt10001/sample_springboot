package com.shouxin.yy.entity.DTO.admin.copywriting;

import lombok.Data;

import java.util.List;

/**
 * @time 2022/6/10
 * @Author xingxing
 */
@Data
public class AddCopywritingDTO {

    /**
     * uuid
     */
    private String uuid;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 文案名
     */
    private String name;
    /**
     * 文案内容
     */
    private String content;
    /**
     * 文案类型id
     */
    private Integer copywritingTypeId;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 图片
     */
    private List<String> copywritingImage;
}
