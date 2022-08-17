package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文案表(Copywriting)实体类
 *
 * @author xingxing
 * @since 2022-06-10
 */
@Data
@TableName("copywriting")
public class CopywritingDO {

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
