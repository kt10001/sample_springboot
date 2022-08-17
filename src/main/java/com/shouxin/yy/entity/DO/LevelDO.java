package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 经理等级表(Level)实体类
 *
 * @author makejava
 * @since 2022-06-23 16:29:09
 */
@Data
@TableName("level")
public class LevelDO {
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
     * 名称
     */
    private String name;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 进件数
     */
    private Integer incomeAmount;
    /**
     * 团队人数
     */
    private Integer memberAmount;
    /**
     * 会员人数
     */
    private Integer vipAmount;
    /**
     * 是否删除 0-否 1-是
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

