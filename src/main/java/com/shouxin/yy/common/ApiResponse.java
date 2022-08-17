package com.shouxin.yy.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回数据格式
 * @time 2022/2/9 11：30 上午
 * @author feikong
 */
@Data
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 2697114670492073235L;

    /**
     * 错误码
     */
    private String respCode;

    /**
     * 错误码信息描述
     */
    private String respMsg;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 返回数据对象
     */
    private T respData;

    public ApiResponse() {};

    public ApiResponse(String code, String msg) {
        this.respCode = code;
        this.respMsg = msg;
        this.respData = null;
        this.requestId = AppContext.getContext().getRequestId();
    }

    public ApiResponse(String code, String msg, T data) {
        this.respCode = code;
        this.respMsg = msg;
        this.respData = data;
        this.requestId = AppContext.getContext().getRequestId();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(
                RespEnum.CODE_SUCCESS.getCode(),
                RespEnum.CODE_SUCCESS.getMessage(),
                data
        );
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(
                RespEnum.CODE_SUCCESS.getCode(),
                RespEnum.CODE_SUCCESS.getMessage()
        );
    }

    public static <T> ApiResponse<T> error() {
        return new ApiResponse<T>(
                RespEnum.CODE_SYSTEM_ERROR.getCode(),
                RespEnum.CODE_SYSTEM_ERROR.getMessage()
        );
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(
                RespEnum.CODE_SYSTEM_ERROR.getCode(),
                message
        );
    }

    public static <T> ApiResponse<T> error(String code, String message) {
        return new ApiResponse<T>(
                code,
                message
        );
    }

    public static <T> ApiResponse<T> paramError(String message) {
        return new ApiResponse<T>(
                RespEnum.CODE_PARAM_ERROR.getCode(),
                message
        );
    }

}