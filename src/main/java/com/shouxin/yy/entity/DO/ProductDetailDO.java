package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 产品详情表(ProductDetail)实体类
 *
 * @author makejava
 * @since 2022-05-13 11:03:27
 */
@Data
@TableName("product_detail")
public class ProductDetailDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 地区
     */
    private String area;
    /**
     * 产品内容
     */
    private String content;
    /**
     * 是否删除 0-使用 1-删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
}

