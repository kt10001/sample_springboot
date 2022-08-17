package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wubaochun
 */
@Data
@TableName("problem_log")
public class ProblemLogDO {
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
     * 问题类型 0-系统bug 1-优化体验 2-功能操作 3-账号登录 4-其他问题 5-商务合作
     */
    private Integer type;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 注册手机号
     */
    private String registerPhone;
    /**
     * 填写手机号
     */
    private String writePhone;
    /**
     * 反馈内容
     */
    private String problem;
    /**
     * 反馈图片
     */
    private String pictureUrl;
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

