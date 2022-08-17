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
@TableName("wx_recharge_journal")
public class WxRechargeJournalDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商家订单号
     */
    private String outTradeNo;
    /**
     * 微信订单号
     */
    private String transactionId;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 客户经理姓名
     */
    private String managerName;
    /**
     * 0未支付1支付成功2支付失败
     */
    private Integer status;
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

