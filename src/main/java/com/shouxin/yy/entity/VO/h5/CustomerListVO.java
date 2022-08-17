package com.shouxin.yy.entity.VO.h5;

import com.shouxin.yy.entity.DO.UnUserFollowLogDO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class CustomerListVO {

    private String unUserUuid;

    private String unUserName;

    private String companyName;

    private Integer progress;

    private String productName;

    private BigDecimal incomeCount;

    private Long incomeMoney;

    private Integer unUserType;

    private String createAt;

    private String updateAt;

    private String progressLog;

    private List<UnUserFollowLogDO> followLogList;

}
