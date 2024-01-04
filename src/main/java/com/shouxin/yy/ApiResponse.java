package com.shouxin.yy;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回数据格式
 * @time 2022/2/9 11：30 上午
 * @author feikong
 */
@Data
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 7746038432708562395L;

    /**
     * code
     */
    private String respCode;

    /**
     * code描述
     */
    private String respMsg;

    /**
     * 时间戳
     */
    private String time = DateUtil.now();

    /**
     * 数据对象
     */
    private T respData;

    public ApiResponse() {};

    public ApiResponse(String code, String msg) {
        this.respCode = code;
        this.respMsg = msg;
        this.respData = null;
    }

    public ApiResponse(String code, String msg, T data) {
        this.respCode = code;
        this.respMsg = msg;
        this.respData = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(
                "200",
                "success"
        );
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(
                "200",
                "success",
                data
        );
    }

    public static <T> ApiResponse<T> error() {
        return new ApiResponse<T>(
                RespEnum.SW_RESP_CODE_SYSTEM_ERROR.getCode(),
                RespEnum.SW_RESP_CODE_SYSTEM_ERROR.getMessage()
        );
    }

    public static ApiResponse<Object> error(String code, String message) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setRespData(new JSONObject());
        apiResponse.setRespCode(code);
        apiResponse.setRespMsg(message);
        return apiResponse;
    }


}