package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


/**
 * @author wubaochun
 */
@Data
@TableName("account_log")
public class AccountLogDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 客户经理姓名
     */
    private String name;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 0税务付费1会员充值
     */
    private Integer type;
    /**
     * 金额
     */
    private BigDecimal money;
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

