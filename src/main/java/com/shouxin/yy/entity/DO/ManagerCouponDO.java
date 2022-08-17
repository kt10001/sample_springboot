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
@TableName("manager_coupon")
public class ManagerCouponDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户uuid
     */
    private String managerUuid;
    /**
     * 现金券uuid
     */
    private String couponUuid;
    /**
     * 现金券类型 0-进件现金券 1-邀请好友进件现金券
     */
    private Integer couponType;
    /**
     * 是否查看 0-否 1-是
     */
    private Integer isCheck;
    /**
     * 发行面额
     */
    private BigDecimal money;
    /**
     * 规则
     */
    private String rule;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 使用时间
     */
    private String useTime;
    /**
     * 进件单号
     */
    private String incomingUuid;
    /**
     * 现金券状态 0-待使用 1-即将过期 2-已使用 3-已失效
     */
    private Integer status;
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

