package com.shouxin.yy.entity.DTO.admin.coupon;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class AddCouponDTO {

    /**
     * 现金券名称
     */
    @NotNull(message = "名称参数错误")
    @Length(max = 30, message = "名称最大长度30")
    private String name;

    /**
     * 参与人群 0-全部 1-新用户 2-老用户 3-指定用户
     */
    @NotNull(message = "参与人群错误")
    private Integer peopleType;

    /**
     * 活动产品 0-全部 1-指定产品
     */
    @NotNull(message = "活动产品错误")
    private Integer productType;

    /**
     * 领取方式 0-后台赠送
     */
    @NotNull(message = "领取方式错误")
    private Integer getType;

    /**
     * 现金券类型 0-进件现金券 1-邀请好友进件现金券
     */
    @NotNull(message = "现金券类型错误")
    private Integer couponType;

    /**
     * 发行数量 -1-无上限
     */
    @NotNull(message = "发行数量错误")
    private Integer counts;

    /**
     * 发行面额
     */
    @NotNull(message = "发行面额错误")
    private BigDecimal money;

    /**
     * 使用门槛 0-无门槛
     */
    @NotNull(message = "使用门槛参数错误")
    private Integer useLimit;

    /**
     * 使用规则
     */
    @Length(max = 200, message = "使用规则最大长度200")
    private String rule;

    /**
     * 备注
     */
    @Length(max = 200, message = "备注最大长度200")
    private String comment;

    /**
     * 有效期类型 0-自定义 1-当前 2-次日
     */
    @NotNull(message = "有效期类型参数错误")
    private Integer timeType;

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
     * 客户经理列表
     */
    private List<String> managerUuidList;

    /**
     * 产品列表
     */
    private List<String> productUuidList;
}
