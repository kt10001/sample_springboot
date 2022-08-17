package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 结算表(Settlement)实体类
 *
 * @author xingxing
 * @since 2022-05-30
 */
@Data
@TableName("settlement")
public class SettlementDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 授信金额
     */
    private BigDecimal creditAmount;
    /**
     * 放款金额
     */
    private BigDecimal loanAmount;
    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;
    /**
     * 业务进度 0-已申请 1-授信中  2-授信通过 3-审批未通过 4-已提款 5-待审核 6-审核不通过 7-审核已通过
     */
    private Integer progress;
    /**
     * 结算状态 0-未结算 1-已结算
     */
    private Integer settlementStatus;
    /**
     * 结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算
     */
    private Integer settlementType;
    /**
     * 进件uuid
     */
    private String incomingUuid;
    /**
     * 备注(失败原因)
     */
    private String remarks;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
    /**
     * 三方放款id
     */
    private String thirdLoanId;


}
