package com.shouxin.yy.entity.DTO.admin.incoming;


import com.shouxin.yy.entity.DTO.EmailDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @time 2022/5/23 10:00 上午
 * @Author xingxing
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListIncomingNoPageDTO extends EmailDTO {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 产品名称
     */
    private String productName;


    /**
     * 客户经理id
     */
    private String managerUuid;


    /**
     * 客户名称
     */
    private String unUserName;

    /**
     * 产品类型
     */
    private Integer productType;

    /**
     * 业务进度
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
