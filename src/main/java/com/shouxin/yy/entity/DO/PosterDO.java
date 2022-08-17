package com.shouxin.yy.entity.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 海报类型(Poster)实体类
 *
 * @author xingxing
 * @since 2022-06-08
 */
@Data
@TableName("poster")
public class PosterDO {

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
     * 海报名
     */
    private String name;
    /**
     * 海报类型id
     */
    private Integer posterTypeId;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 图片
     */
    private String image;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}
