package com.shouxin.yy.entity.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表(UnUser)实体类(客户经理的用户)
 *
 * @author xingxing
 * @since 2022-05-24 14:50:06
 */
@Data
@TableName("un_user")
public class UnUserDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * 用户uuid
     */
    private String uuid;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户类型
     */
    private Integer type;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 备注
     */
    private String comment;
}
