package com.shouxin.yy.common.exception;


import com.alibaba.fastjson.JSONObject;
import com.shouxin.yy.common.RespEnum;

/**
 * @time 2022/2/9 1:58 下午
 * @Author feikong
 */
public class SuccessedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private JSONObject data;

    public SuccessedException(String msg, Throwable e) {
        super(msg, e);
    }

    public SuccessedException(String msg, Integer code) {
        super(msg);
        this.code = code.toString();
    }

    public SuccessedException(JSONObject data) {
        this.data = data;
    }

    public SuccessedException(String msg, Throwable e, Integer code) {
        super(msg, e);
        this.code = code.toString();
    }

    public SuccessedException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public SuccessedException(String msg, Throwable e, String code) {
        super(msg, e);
        this.code = code;
    }

    /**
     * 默认自定义异常
     * @param code
     */
    public SuccessedException(String code){
        super(RespEnum.findMsg(code));
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public JSONObject getData() {
        return data;
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
