package com.shouxin.yy.entity.VO;

import lombok.Data;

import java.util.List;

/**
 * @time 2021/4/25 10:29 下午
 * @Author feikong
 */

@Data
public class PermissionVO {

    private String uuid;
    private String parentId;
    private String name;
    private String url;
    private Boolean chosen = false;
    private List<PermissionVO> child;

}
