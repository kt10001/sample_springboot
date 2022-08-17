package com.shouxin.yy.entity.DTO.announcement;

import com.shouxin.yy.entity.VO.AnnouncementVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/6 9:29 上午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateDTO extends AnnouncementVO {

    @NotNull(message = "uuid参数错误")
    private String uuid;
}
