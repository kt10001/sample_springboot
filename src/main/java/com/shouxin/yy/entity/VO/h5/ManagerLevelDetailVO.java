package com.shouxin.yy.entity.VO.h5;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@AllArgsConstructor
public class ManagerLevelDetailVO {

    /**
     * 经理等级名称
     */
    private String levelName;
    /**
     * 高级经理进件数
     */
    private Integer incoming;
    /**
     * 高级总监进件数
     */
    private Integer incoming2;
    /**
     * 已进件数
     */
    private Integer beIncoming;
    /**
     * 高级经理团队人数
     */
    private Integer teamCount;
    /**
     * 高级总监团队人数
     */
    private Integer teamCount2;
    /**
     * 已达团队人数
     */
    private Integer beTeamCount;
    /**
     * 高级经理会员数
     */
    private Integer vipCount;
    /**
     * 高级总监会员数
     */
    private Integer vipCount2;
    /**
     * 已成为会员数
     */
    private Integer beVipCount;
    /**
     * 升级时间
     */
    private String levelTime;

}
