package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@TableName("manager_level")
public class ManagerLevelDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户uuid
     */
    private String managerUuid;
    /**
     * 会员uuid
     */
    private String levelUuid;
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
     * 已达好友人数
     */
    private Integer beFriendCount;
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
     * 高级经理是否通知
     */
    private Integer isSend;
    /**
     * 高级总监是否通知
     */
    private Integer isSend2;
    /**
     * 是否被邀请
     */
    private Integer isInvite;
    /**
     * 邀请时间
     */
    private String friendTime;
    /**
     * 升级时间
     */
    private String levelTime;
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

