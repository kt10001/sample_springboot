package com.shouxin.yy.entity.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 入账表(ManagerEntry)实体类
 *
 * @author xingxing
 * @since 2022-06-01 20:02:23
 */
@TableName("manager_entry")
@Data
public class ManagerEntryDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 进件单号
     */
    private String incomingUuid;
    /**
     * 客户经理uuid
     */
    private String managerUuid;
    /**
     * 产品uuid
     */
    private String productUuid;
    /**
     * 入账金额
     */
    private BigDecimal amount;
    /**
     * 0产品入账1活动入账
     */
    private Integer type;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}
