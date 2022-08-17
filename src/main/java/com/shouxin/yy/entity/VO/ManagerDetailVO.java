package com.shouxin.yy.entity.VO;

import com.shouxin.yy.entity.DO.ManagerDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @time 2022/5/11 9:29 下午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerDetailVO extends ManagerDO {

    /**
     * 是否实名
     */
    private Boolean isVerify;

    /**
     * 是否签署电子合同
     */
    private Boolean isContract;

    /**
     * 会员名称
     */
    private String vipName;

    /**
     * 经理等级名称
     */
    private String levelName;
}
