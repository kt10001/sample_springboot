package com.shouxin.yy.entity.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 信用卡产品详情表(ProductCreditDetailDO)实体类
 *
 * @author xingxing
 * @since 2022-05-18 14:53:27
 */
@Data
@TableName("product_credit_detail")
public class ProductCreditDetailDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品uuid
     */
    private String productCreditUuid;
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
