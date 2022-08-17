package com.shouxin.yy.entity.VO.bg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @time 2022/7/18 3:38 下午
 * @Author feikong
 */
@Data
public class FreezeVO {

    /**
     * 微信昵称
     */
    private String wxName;
    /**
     * 上上级id
     */
    private String superParentUuid;
    /**
     * 微信头像
     */
    private String headUrl;
    /**
     * 注册时间
     */
    private String createTime;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * managerUuid
     */
    private String managerUuid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 冻结时间
     */
    private String freezeTime;
    /**
     * 冻结原因
     */
    private String freezeReason;
    /**
     * 解冻时间
     */
    private String unFreezeTime;
    /**
     * 解冻原因
     */
    private String unFreezeReason;
    /**
     * 操作类型 0-冻结 1-解冻
     */
    private Integer type;
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
