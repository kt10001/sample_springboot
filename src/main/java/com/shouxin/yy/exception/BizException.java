package com.shouxin.yy.exception;


import com.shouxin.yy.RespEnum;

/**
 * @time 2022/2/9 1:36 下午
 * @Author feikong
 */
public class BizException  extends Exception {
    private static final long serialVersionUID = 9149193659566183541L;

    private RespEnum respEnum;

    public RespEnum getExceptionEnums() {
        return this.respEnum;
    }

    public BizException() {}

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String errCode, String errMsg) {
        super(errMsg);
    }

    public BizException(RespEnum exceptionEnums) {
        this.respEnum = exceptionEnums;
    }

    public BizException(Throwable t, RespEnum exceptionEnums) {
        super(t);
        this.respEnum = exceptionEnums;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "respEnum=" + respEnum +
                '}';
    }
}

