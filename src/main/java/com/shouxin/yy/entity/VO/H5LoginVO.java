package com.shouxin.yy.entity.VO;

import lombok.Data;

/**
 * @time 2022/5/2 10:46 上午
 * @Author feikong
 */
@Data
public class H5LoginVO {

    private String token;

    private String uuid;

    /**
     * 是否实名
     */
    private Boolean isVerify;

    /**
     * 是否签署电子合同
     */
    private Boolean isContract;
}
