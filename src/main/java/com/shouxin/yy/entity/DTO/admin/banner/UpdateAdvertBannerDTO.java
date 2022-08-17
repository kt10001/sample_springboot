package com.shouxin.yy.entity.DTO.admin.banner;

import com.shouxin.yy.entity.DO.AdvertBannerDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @time 2022/5/10 11:56 上午
 * @Author feikong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateAdvertBannerDTO extends AdvertBannerDO {

    @NotNull(message = "uuid参数错误")
    private String uuid;

}
