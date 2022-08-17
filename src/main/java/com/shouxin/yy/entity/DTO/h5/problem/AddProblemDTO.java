package com.shouxin.yy.entity.DTO.h5.problem;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wubaochun
 */
@Data
public class AddProblemDTO {

    /**
     * 问题类型 0-系统bug 1-优化体验 2-功能操作 3-账号登录 4-其他问题 5-商务合作
     */
    @NotNull(message = "问题类型参数错误")
    private Integer type;

    /**
     * 填写手机号
     */
    private String writePhone;

    /**
     * 反馈图片
     */
    private List<String> pictureUrl;

    /**
     * 反馈内容
     */
    @NotNull(message = "反馈内容参数错误")
    private String problem;

}
