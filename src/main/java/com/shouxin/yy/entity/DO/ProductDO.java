package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 产品表(Product)实体类
 *
 * @author makejava
 * @since 2022-05-12 16:04:06
 */
@Data
@TableName("product")
public class ProductDO {
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
     * 全称
     */
    private String fullName;
    /**
     * 类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷
     */
    private Integer type;
    /**
     * 机构
     */
    private String company;
    /**
     * 排序值
     */
    private Integer rankValue;
    /**
     * 额度
     */
    private Integer amount;
    /**
     * logo
     */
    private String logo;
    /**
     * 利率 多个利率,隔开
     */
    private String rate1;
    private String rate2;
    /**
     * 还款方式 0-等额本息 1-等额本金 2-等本等息 3-先息后本
     */
    private String repayType;
    /**
     * 贷款周期，多个周期,隔开
     */
    private String loanMonth;
    /**
     * 结算方式 0-授信结算 1-放款结算
     */
    private Integer billType;
    /**
     * 产品链接
     */
    private String link;
    /**
     * 返佣方式
     * 0 - 按比例
     * 1 - 按金额
     */
    private Integer incomeType;
    /**
     * 返佣比例
     */
    private BigDecimal incomeRate;
    /**
     * 会员返佣比例
     */
    private BigDecimal vipARate;
    private BigDecimal vipBRate;
    /**
     * 返佣金额
     */
    private BigDecimal incomeM;
    /**
     * 会员返佣金额
     */
    private BigDecimal vipAM;
    private BigDecimal vipBM;
    /**
     * 出师奖
     */
    private BigDecimal levelARate;
    /**
     * 越级奖
     */
    private BigDecimal levelBRate;
    /**
     * 标签
     */
    private String label;
    /**
     * 状态 0-下架 1-上架
     */
    private Integer status;
    /**
     * 是否删除 0-使用 1-删除
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

