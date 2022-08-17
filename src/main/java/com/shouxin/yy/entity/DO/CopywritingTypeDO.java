package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文案类型表(CopywritingType)实体类
 *
 * @author xingxing
 * @since 2022-06-09
 */
@Data
@TableName("copywriting_type")
public class CopywritingTypeDO {

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
