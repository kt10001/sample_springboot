package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户经理表(Manager)实体类
 *
 * @author makejava
 * @since 2022-05-11 15:27:27
 */
@Data
@TableName("manager")
public class ManagerDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * uuid
     */
    private String uuid;
    private String parentUuid;
    /**
     * 姓名
     */
    private String name;
    private String username;
    /**
     * 身份证
     */
    private String identNumber;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 微信号
     */
    private String wxId;
    /**
     * openId
     */
    private String openId;

    /**
     * 头像
     */
    private String pictureUrl;

    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 最近一次登录时间
     */
    private String loginTime;
    /**
     * 是否重新发过券 0-否 1-是
     */
    private Integer isSend;
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

