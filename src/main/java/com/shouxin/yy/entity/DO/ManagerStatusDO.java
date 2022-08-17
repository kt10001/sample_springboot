package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 客户经理状态表（目前只有积分状态）(ManagerStatus)实体类
 *
 * @author makejava
 * @since 2022-08-04 18:15:39
 */
@TableName("manager_status")
@Data
public class ManagerStatusDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 积分状态（0未冻结1已冻结）
     */
    private Integer integralStatus;
    /**
     * 是否签到提醒 0-否 1-是
     */
    private Integer signStatus;
    /**
     * 是否关注公众号 0-是 1-否
     */
    private Integer isFollow;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 修改时间
     */
    private String updateAt;
}