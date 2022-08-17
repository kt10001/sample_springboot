package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 匹配记录表(MatchLog)实体类
 *
 * @author makejava
 * @since 2022-05-19 13:41:46
 */
@Data
@TableName("match_log")
public class MatchLogDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 产品类型
     */
    private String type;
    /**
     * 产品额度
     */
    private Integer amount;
    /**
     * 产品数量
     */
    private Integer num;
    /**
     * 产品列表
     */
    private String detail;
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

