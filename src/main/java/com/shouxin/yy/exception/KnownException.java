package com.shouxin.yy.exception;


import com.shouxin.yy.RespEnum;

/**
 * @author wubaochun
 */
public class KnownException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    public KnownException(String msg, Throwable e) {
        super(msg, e);
    }

    public KnownException(String msg, Integer code) {
        super(msg);
        this.code = code.toString();
    }

    public KnownException(String msg, Throwable e, Integer code) {
        super(msg, e);
        this.code = code.toString();
    }

    public KnownException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg =msg;
    }

    public KnownException(String msg, Throwable e, String code) {
        super(msg, e);
        this.code = code;
    }

    /**
     * 默认自定义异常
     * @param code
     */
    public KnownException(String code){
        super(RespEnum.findMsg(code));
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
