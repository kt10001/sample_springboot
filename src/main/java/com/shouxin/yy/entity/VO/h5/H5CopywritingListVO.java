package com.shouxin.yy.entity.VO.h5;

import lombok.Data;

import java.util.List;

/**

 *
 * @author xingxing
 * @since 2022-06-14
 */
@Data
public class H5CopywritingListVO {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 文案内容
     */
    private String content;
    /**
     * 文案类型id
     */
    private Integer copywritingTypeId;
    /**
     * 更新时间
     */
    private String updateAt;

    /**
     * 客户经理
     */
    private String managerName;

    /**
     * 头像
     */
    private String pictureUrl;

    /**
     * 图片
     */
    private List<String> images;
}
