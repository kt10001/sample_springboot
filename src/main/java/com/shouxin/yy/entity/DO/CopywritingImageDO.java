package com.shouxin.yy.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文案图片表(Copywriting)实体类
 *
 * @author xingxing
 * @since 2022-06-10
 */
@Data
@TableName("copywriting_image")
public class CopywritingImageDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文案uuid
     */
    private String copywritingUuid;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建时间
     */
    private String createAt;
    /**
     * 更新时间
     */
    private String updateAt;
}
