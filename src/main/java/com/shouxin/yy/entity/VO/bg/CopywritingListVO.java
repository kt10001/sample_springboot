package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

import java.util.List;

@Data
public class CopywritingListVO {

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
     * 图片
     */
    private List<String> copywritingImage;
    /**
     * 文案类型名
     */
    private String copywritingType;
    /**
     * 产品
     */
    private String productName;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 海报类型
     */
    private Integer copywritingTypeId;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;

}
