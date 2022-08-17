package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户经理提现记录表(ManagerIncome)实体类
 *
 * @author makejava
 * @since 2022-05-24 11:34:41
 */
@TableName("manager_income")
@Data
public class ManagerIncomeDO {
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
     * 提现请求id
     */
    private String requestId;

    /**
     * 后台审批状态
     * 0-待审核 1-已通过 2-未通过
     */
    private Integer bgStatus;
    /**
     * 状态(20:成功 30:失败 50:划付中 40:未划付)
     */
    private String status;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 提现金额
     */
    private BigDecimal amount;
    /**
     * 实发金额
     */
    private BigDecimal currentRealWage;
    /**
     * 当次缴纳个税 （算税方式为标准时个税）
     */
    private BigDecimal currentTax;
    /**
     * 当次提现管理费 （算税方式为标准时管理费）
     */
    private BigDecimal currentManageFee;
    /**
     * 当次提现附加税（算税方式为标准时附加税）
     */
    private BigDecimal currentAddTax;
    /**
     * 当次提现增值税（算税方式为标准时增值税）
     */
    private BigDecimal currentAddValueTax;
    /**
     * 身份证号码
     */
    private String identity;
    /**
     * 银行名称
     */
    private String bankname;
    /**
     * 银行卡
     */
    private String bankaccount;
    /**
     * 申请时间(yyyyMMddHHmmss)
     */
    private String datetime;
    /**
     * 实际付款时间(yyyyMMddHHmmss)
     */
    private String paytime;
    /**
     * 单据描叙
     */
    private String remark;
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

    /**
     * 备注
     */
    private String comment;
}

