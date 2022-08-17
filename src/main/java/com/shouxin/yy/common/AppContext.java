package com.shouxin.yy.common;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Data;

import java.io.Serializable;

/**
 * @time 2022/2/11 10:21 上午
 * @Author feikong
 */
@Data
public class AppContext implements Serializable {
    public static final String KEY_REQUEST_ID = "requestId";
    private static final long serialVersionUID = -1078197840446192925L;

    /**
     * 全局request_id 也用作订单号
     */
    private String requestId;

    /**
     * 请求时间
     */
    private Long requestTime;

    /**
     * 登录用户uuid
     */
    private String userId;

    private static final TransmittableThreadLocal<AppContext> LOCAL = new TransmittableThreadLocal<AppContext>() {
        @Override
        protected AppContext initialValue() {
            return new AppContext();
        }
    };

    public static AppContext getContext() {
        return LOCAL.get();
    }

    public static void setContext(AppContext context) {
        LOCAL.set(context);
    }

    public static void removeContext() {
        LOCAL.remove();
    }
}