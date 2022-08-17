package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品通过率查询记录表(PassLog)实体类
 *
 * @author makejava
 * @since 2022-05-20 15:27:20
 */
@Data
@TableName("pass_log")
public class PassLogDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    private String name;
    /**
     * 查询记录
     */
    private String pass;
    /**
     * 其他产品数量
     */
    private Integer num;
    /**
     * 查询结果详情
     */
    private String detail;
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

