package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 海报类型(PosterType)实体类
 *
 * @author xingxing
 * @since 2022-06-08
 */
@Data
@TableName("poster_type")
public class PosterTypeDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 海报类型名
     */
    private String name;
    /**
     * 是否删除 0-使用 1-删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}
