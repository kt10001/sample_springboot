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
@TableName("coupon")
public class CouponDO {
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
     * 现金券名称
     */
    private String name;
    /**
     * 参与人群 0-全部 1-新用户 2-老用户 3-指定用户
     */
    private Integer peopleType;
    /**
     * 活动产品 0-全部 1-指定产品
     */
    private Integer productType;
    /**
     * 领取方式 0-后台赠送
     */
    private Integer getType;
    /**
     * 现金券类型 0-进件现金券 1-邀请好友进件现金券
     */
    private Integer couponType;
    /**
     * 发放状态 0-发放中 1-停止发放
     */
    private Integer sendType;
    /**
     * 有效期类型 0-自定义 1-当前 2-次日
     */
    private Integer timeType;
    /**
     * 发行数量 -1-无上限
     */
    private Integer counts;
    /**
     * 发行面额
     */
    private BigDecimal money;
    /**
     * 使用门槛 0-无门槛
     */
    private Integer useLimit;
    /**
     * 使用规则
     */
    private String rule;
    /**
     * 备注
     */
    private String comment;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 有效期天数
     */
    private Integer day;
    /**
     * 停止发券原因
     */
    private String noSendReason;
    /**
     * 失效原因
     */
    private String deletedReason;
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

