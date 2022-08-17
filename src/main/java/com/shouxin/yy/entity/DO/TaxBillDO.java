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
@TableName("tax_bill_journal")
public class TaxBillDO {
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
     * 客户姓名
     */
    private String name;
    /**
     * 统一社会信用代码
     */
    private String licenseNum;
    /**
     * 税票信息
     */
    private String taxMsg;
    /**
     * 纳税等级
     */
    private String creditLevel;
    /**
     * 近12月有效开票月份
     */
    private Integer fpPrev12mthsMthsOfAmtEq0;
    /**
     * 近12月有效开票对象
     */
    private Integer fpFirst12mthsSupplier;
    /**
     * 连续开票时长
     */
    private Integer fpMaxbilldttdTmspan;
    /**
     * 企业纳税欠缴次数
     */
    private Integer cntOfPendingTaxarrearcase;
    /**
     * 12月内开票金额总计
     */
    private BigDecimal fpPrev12mthsTotAmt;
    /**
     * 12月内纳税额缴纳总计
     */
    private BigDecimal taxPpev12mthsTaxPaid;
    /**
     * 近12个月应税销售额
     */
    private BigDecimal taxPrev12mthsTaxPayable;
    /**
     * 近12个月申报经营收入
     */
    private BigDecimal taxPrev12mthsIncome;
    /**
     * 过期时间
     */
    private String expireTime;
    /**
     * 采集状态 0-未采集 1-采集中 2-采集完成 3-调用完成
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

