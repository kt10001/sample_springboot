package com.shouxin.yy;


/**
 * @time 2021/4/14 12:27 上午
 * @Author feikong
 */

public enum RespEnum {

    /**
     * 返回码Table
     */
    SW_RESP_CODE_SUCCESS("SW0000", "查询成功"),
    SW_RESP_CODE_VERIFY_FAIL("SW0001", "认证失败"),
    SW_RESP_CODE_NOT_FOUND("SW0002", "查询无记录"),
    SW_RESP_CODE_CHANNEL_TIMEOUT("SW0003", "通道异常"),
    SW_RESP_CODE_FAIL("SW0004", "查询失败，请重新发起"),
    SW_RESP_CODE_REFUSE("SW0005", "查询拒绝，违反相关查询规则"),
    SW_RESP_CODE_AGAIN("SW0006", "暂时无查询结果，请稍后查询"),
    SW_RESP_CODE_QUERY("SW0007", "接口超时，请通过查询接口获取结果"),
    SW_RESP_CODE_ZX_NULL("SW0008", "征信空白"),
    SW_RESP_CODE_BIZDATA_TYPE_ERROR("SW0016", "参数类型错误"),
    SW_RESP_CODE_BIZDATA_ERROR("SW0017", "biz_data参数错误"),
    SW_RESP_CODE_DATA_ERROR("SW0018", "参数错误"),
    SW_RESP_CODE_DATA_INCORRECT("SW0019", "参数有误或信息不足"),
    SW_RESP_CODE_DATA_MISSING("SW0020", "必传参数缺失"),
    SW_RESP_CODE_SIGN_EMPTY("SW0030", "签名为空"),
    SW_RESP_CODE_PUB_KEY_EMPTY("SW0031", "客户公钥为空"),
    SW_RESP_CODE_VERIFY_SIGN_FAIL("SW0032", "验签失败"),
    SW_RESP_CODE_VERIFY_SIGN_ERROR("SW0033", "验签错误"),
    SW_RESP_CODE_DECRYPT_FAIL("SW0034", "解密失败"),
    SW_RESP_CODE_PRODUCT_NOT_PURCHASE("SW0040", "产品未开通"),
    SW_RESP_CODE_CALL_LIMIT("SW0041", "调用量已达上限"),
    SW_RESP_CODE_BALANCE_NOT_ENOUGH("SW0042", "账户余额不足"),
    SW_RESP_CODE_PRODUCT_IS_DISABLE("SW0043", "产品已下线"),
    SW_RESP_CODE_PRODUCT_NO_PRICE("SW0044", "产品没有添加价格，请联系客服解决"),
    SW_RESP_CODE_TRADE_ERROR("SW0051", "交易失败，详情请咨询您的发卡行"),
    SW_RESP_CODE_CARD_ERROR("SW0052", "银行卡暂不支持或权限受限，请联系客服!"),
    SW_RESP_CODE_NAME_FORMAT_ERROR("SW1009", "姓名格式有误"),
    SW_RESP_CODE_ID_FORMAT_ERROR("SW1010", "身份证号格式有误"),
    SW_RESP_CODE_BANKCARD_FORMAT_ERROR("SW1011", "卡号格式有误"),
    SW_RESP_CODE_PHONE_FORMAT_ERROR("SW1012", "手机号格式有误"),
    SW_RESP_CODE_PHOTO_QUALITY_UNQUALIFIED("SW1013", "图片质量不合格"),
    SW_RESP_CODE_REACH_LIMIT("SW1015", "交易次数超限或操作过频"),
    SW_RESP_CODE_NOT_UTF8("SW1016", "交易失败/异常"),
    SW_RESP_CODE_NO_RECORD("SW1017", "请求失败，查询无记录，请检查入参"),
    SW_RESP_CODE_MAX_RECORD_LIMIT("SW1018", "最大支持查询条数不能超过10000条"),
    SW_RESP_CODE_NOT_SUPPORT_PHONE("SW1019", "手机号段不支持"),
    SW_RESP_CODE_NOT_SUPPORT_AREA("SW1021", "查询地区不支持"),
    SW_RESP_PARAMS_NOT_EQ_ENCRPTION("SW1022", "参数与加密方式不符"),
    SW_RESP_WS_ERROR("SW5000", "查询无记录"),
    SW_RESP_ZF_CANT_REQUEST("SW5001", "该产品在当前时间段禁止调用，调用时间AM 8：00 -- PM：8：00"),
    SW_RESP_REPEAT_CALL("SW5002", "同一用户单日重复调用量上限"),
    SW_RESP_CODE_SYSTEM_ERROR("SW9999", "系统错误"),
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