package com.shouxin.yy.entity.VO.h5;

import com.shouxin.yy.entity.DO.UnUserFollowLogDO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class CustomerDetailVO {

    private String uuid;

    private String companyName;

    private String name;

    private String phone;

    private Integer progress;

    private String createAt;

    private String updateAt;

    private String productName;

    private Long incomeCount;

    private BigDecimal incomeMoney;

    private List<CustomerProductDetailVO> progressLog;

    private List<UnUserFollowLogDO> followLogList;

    private Long day;

    private String comment;

}
