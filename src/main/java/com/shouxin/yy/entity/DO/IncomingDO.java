package com.shouxin.yy.entity.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 进件表(Incoming)实体类
 *
 * @author xingxing
 * @since 2022-05-23
 */
@Data
@TableName("incoming")
public class IncomingDO {

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
     * 产品名称
     */
    private String productName;
    /**
     * 产品机构
     */
    private String productCompany;
    /**
     * 客户名称
     */
    private String unUserName;
    /**
     * 客户经理名称
     */
    private String managerName;
    /**
     * 结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算
     */
    private Integer settlementType;

    /**
     * 产品类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡
     */
    private Integer productType;
    /**
     * 业务进度 0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过
     */
    private Integer progress;
    /**
     * 用户身份 0企业客户 1个人客户
     */
    private Integer unUserType;
    /**
     * 返佣方式
     * 0 - 按比例
     * 1 - 按金额
     */
    private Integer incomeType;

    /**
     * 会员返佣比例
     */
    private BigDecimal vipARate;
    private BigDecimal vipBRate;
    /**
     * 会员返佣金额
     */
    private BigDecimal vipAM;
    private BigDecimal vipBM;
    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;
    /**
     * 结算状态
     */
    private Integer settlementStatus;
    /**
     * 客户uuid
     */
    private String unUserUuid;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
    /**
     * 申请时间
     */
    private String applyAt;
    /**
     * 授信时间
     */
    private String creditAt;
    /**
     * 放款时间
     */
    private String loanAt;
    /**
     * 结算时间
     */
    private String settlementAt;
    /**
     * 三方进件id
     */
    private String thirdId;
}
