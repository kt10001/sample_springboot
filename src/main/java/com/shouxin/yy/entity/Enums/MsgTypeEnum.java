package com.shouxin.yy.entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息类型
 * @time 2021/10/8 2:14 下午
 * @Author feikong
 */
@Getter
@AllArgsConstructor
public enum MsgTypeEnum {
    /**
     * 消息类型
     */
    SYSTEM(0, "系统消息"),
    TEAM(1, "团队消息"),
    BUSINESS(2, "业务消息"),
    ;

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link MsgTypeEnum } 实例
     **/
    public static MsgTypeEnum find(String code) {
        for (MsgTypeEnum instance : MsgTypeEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }
}