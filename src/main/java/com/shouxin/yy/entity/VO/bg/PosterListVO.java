package com.shouxin.yy.entity.VO.bg;

import lombok.Data;

/**
 *
 * @author xingxing
 * @since 2022-06-08
 */
@Data
public class PosterListVO {
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 海报名
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 海报类型名
     */
    private String posterType;
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
    private Integer posterTypeId;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;
    /**
     * uuid
     */
    private String uuid;
}
