package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色权限表(RolePermission)实体类
 *
 * @author makejava
 * @since 2022-05-02 21:25:07
 */
@Data
@TableName("role_permission")
public class RolePermissionDO implements Serializable {
    private static final long serialVersionUID = 248375897947860079L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色uuid
     */
    private String roleUuid;
    /**
     * 权限uuid
     */
    private String permissionUuid;
    /**
     * 是否删除 0-否 1-是
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

}

