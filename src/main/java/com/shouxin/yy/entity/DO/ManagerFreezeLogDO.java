package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@TableName("manager_freeze_log")
public class ManagerFreezeLogDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * managerUuid
     */
    private String managerUuid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 冻结时间
     */
    private String freezeTime;
    /**
     * 冻结原因
     */
    private String freezeReason;
    /**
     * 解冻时间
     */
    private String unFreezeTime;
    /**
     * 解冻原因
     */
    private String unFreezeReason;
    /**
     * 操作类型 0-冻结 1-解冻
     */
    private Integer type;
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

