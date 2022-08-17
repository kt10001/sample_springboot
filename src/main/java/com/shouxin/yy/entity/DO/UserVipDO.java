package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author wubaochun
 */
@Data
@TableName("user_vip")
public class UserVipDO {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户uuid
     */
    private String userUuid;
    /**
     * 会员uuid
     */
    private String vipUuid;
    /**
     * 是否终身0否1是
     */
    private Integer type;
    /**
     * 会员过期时间
     */
    private Date expireTime;
    /**
     * 是否领取 0-否 1-是
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

