package com.shouxin.yy.entity.DTO.admin.incoming;

import com.shouxin.yy.entity.DTO.PageDTO;
import lombok.Data;

/**
 * @time 2022/5/24 10:00 上午
 * @Author xingxing
 */
@Data
public class H5ListIncomingDTO extends PageDTO {

    /**
     * 是否是贷款产品
     */
    private Boolean isLoan;

    /**
     * 搜索框
     */
    private String search;

    /**
     * 客户名称
     */
    private String unUserName;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 业务进度 0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过
     */
    private Integer progress;

    /**
     * 结算状态
     */
    private Integer settlementStatus;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
