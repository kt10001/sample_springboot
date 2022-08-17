package com.shouxin.yy.common;


/**
 * @time 2021/4/14 12:27 上午
 * @Author feikong
 */

public enum RespEnum {

    /**
     * 返回码Table
     */
    // CD0xxxxx 成功
    CODE_SUCCESS("CD0000", "成功"),

    // CD1xxxx 参数错误
    CODE_VERIFY_CODE_ERROR("CD1000", "验证码错误"),
    CODE_TOKEN_ERROR("CD1001", "token错误"),
    CODE_PARAM_ERROR("CD1002", "参数错误"),

    // CD2xxxx 数据错误
    CODE_TOKEN_EXPIRE("CD2000", "登录信息失效，请重新登录"),
    CODE_ENTITY_EXIST("CD2001", "操作实体已存在"),
    CODE_ENTITY_NOT_EXIST("CD2002", "操作实体不存在"),
    CODE_DATA_ERROR("CD2003", "数据错误"),
    CODE_THIRD_INTERFACE_ERROR("CD2004", "第三方数据错误"),
    CODE_DATA_LIMIT("CD2005", "数据限制"),
    NO_REAL_NAME("CD2006", "未实名"),

    // CD3xxx 执行/权限
    CODE_NO_AUTH("CD3000", "权限不足"),
    CODE_OPT_ERROR("CD3001", "操作失败"),

    // CD9xxxx 系统错误
    CODE_SYSTEM_ERROR("CD9999", "系统错误"),
    ;

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    RespEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link RespEnum } 实例
     **/
    public static RespEnum find(String code) {
        for (RespEnum instance : RespEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance;
            }
        }
        return null;
    }

    /**
     * 根据编码查找枚举描述
     *
     * @param code 编码
     * @return {@link RespEnum } 实例
     **/
    public static String findMsg(String code) {
        for (RespEnum instance : RespEnum.values()) {
            if (instance.getCode()
                    .equals(code)) {
                return instance.getMessage();
            }
        }
        return null;
    }

}