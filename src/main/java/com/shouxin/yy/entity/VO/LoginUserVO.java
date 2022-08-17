package com.shouxin.yy.entity.VO;

import lombok.Data;

import java.util.Set;

/**
 * shiro 登录用户信息
 * @time 2022/4/26 8:06 下午
 * @Author feikong
 */
@Data
public class LoginUserVO {
    /**
     * 登录人id
     */
    private String id;

    /**
     * 登录人账号/phone
     */
    private String username;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 是否实人认证
     */
    private Boolean isVerify;

    /**
     * 是否签署电子合同
     */
    private Boolean isContract;
}
