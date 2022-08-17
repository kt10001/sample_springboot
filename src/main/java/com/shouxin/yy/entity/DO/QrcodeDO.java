package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 角色表(QrcodeDO)实体类
 *
 * @author xingxing
 * @since 2022-06-06 20:25:07
 */
@Data
@TableName("qr_code")
public class QrcodeDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 参数内容
     */
    private String context;
    /**
     * 0-贷款产品 1信用卡产品
     */
    private Integer isLoan;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
}
