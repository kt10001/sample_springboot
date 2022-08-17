package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wubaochun
 */
@Data
@TableName("config_property")
public class ConfigPropertyDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 配置名称
     */
    private String configKey;
    /**
     * 配置的值
     */
    private String configValue;
    /**
     * 0-String 1-Integer 2-JsonArray 3-JsonObject 4-List
     */
    private Integer configType;
    /**
     * 是否删除 0-否 1-是
     */
    private Integer isDeleted;
    /**
     * 此配置备注信息
     */
    private String comment;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}

