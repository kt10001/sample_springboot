package com.shouxin.yy.entity.VO;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @time 2022/5/2 10:46 上午
 * @Author feikong
 */
@Data
@Builder
public class LoginVO {

    private String token;

    private String uuid;

    private Boolean isFirstLogin;

    private Set<String> permissions;
}
