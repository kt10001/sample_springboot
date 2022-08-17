package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 合同表(Contract)实体类
 *
 * @author makejava
 * @since 2022-05-23 17:58:07
 */
@Data
@TableName("contract")
public class ContractDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 身份证
     */
    private String identNumber;
    /**
     * 合同id
     */
    private String contractId;
    /**
     * 合同模板id
     */
    private String templateId;
    /**
     * 合同文件
     */
    private String file;
    /**
     * 签署状态 1 - 待签约（员工已同步，但未发起签约） 2 - 签约文件生成中（用户已确认签署，合同文件正在生成，此状态可发起提现） 3 - 签约完成 （用户已签约，签约合同生成完成）
     */
    private Integer status;
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

