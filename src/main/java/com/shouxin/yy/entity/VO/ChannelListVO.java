package com.shouxin.yy.entity.VO;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author wubaochun
 */
@Data
public class ChannelListVO {

    /**
     * 客户经理名称
     */
    private String name;
    /**
     * 客户经理uuid
     */
    private String uuid;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 上级ID
     */
    private String parentUuid;
    /**
     * 经理等级(1服务经理2高级经理3高级总监)
     */
    private Integer managerLevel;
    /**
     * 会员等级(1普通会员2超级会员)
     */
    private Integer level;
    /**
     * 会员有效期
     */
    private String expireTime;
    /**
     * 进件总额
     */
    private BigDecimal settlementAmount;
    /**
     * 累计提现
     */
    private BigDecimal amount;
    /**
     * 客户数量
     */
    private Integer unUserCount;
    /**
     * 团队人数
     */
    private Integer teamCount;
    /**
     * 冻结时间
     */
    private String freezeTime;
    /**
     * 冻结原因
     */
    private String freezeReason;

    /**
     * 微信昵称
     */
    private String wxName;
    /**
     * 上上级id
     */
    private String superParentUuid;
    /**
     * 微信头像
     */
    private String headUrl;
    /**
     * 注册时间
     */
    private String createTime;
}