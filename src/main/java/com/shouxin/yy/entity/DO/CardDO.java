package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@TableName("card")
public class CardDO {
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
     * 名称
     */
    private String name;
    /**
     * 身份
     */
    private String position;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 微信号
     */
    private String wxId;
    /**
     * 工号
     */
    private String userUuid;
    /**
     * 名片模板地址
     */
    private String tempCardUrl;
    /**
     * 头像地址
     */
    private String pictureUrl;
    /**
     * 二维码
     */
    private String code;
    /**
     * 备注
     */
    private String comment;
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

