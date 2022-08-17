package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品动态表(ProductMsg)实体类
 *
 * @author makejava
 * @since 2022-05-13 11:03:28
 */
@Data
@TableName("product_msg")
public class ProductMsgDO {
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
     * 产品动态
     */
    private String msg;
    /**
     * 是否删除 0-使用 1-删除
     */
    private Integer isDeleted;
    /**
     * 是否发布 0-未发布 1-已发布
     */
    private Integer isFab;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;

}

