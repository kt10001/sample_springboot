package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Mock返回数据表(MockRespData)实体类
 *
 * @author makejava
 * @since 2022-04-23 21:26:11
 */
@Data
@TableName("mock_resp_data")
public class MockRespDataDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 请求的uri
     */
    private String uri;
    /**
     * 返回数据类型 1-正常返回 2-异常返回
     */
    private Integer type;
    /**
     * mock返回结果
     */
    private String response;
    /**
     * 是否删除 1-删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createAt;

}

