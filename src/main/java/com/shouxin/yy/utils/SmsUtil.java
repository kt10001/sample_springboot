package com.shouxin.yy.utils;

import com.alibaba.fastjson.JSONObject;
import com.shouxin.yy.common.RespEnum;
import com.shouxin.yy.common.exception.WorkingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;

/**
 * @time 2022/3/14 9:06 下午
 * @Author feikong
 */
@Slf4j
public class SmsUtil {
    private static final String username = "hzsxhy";
    private static final String password = "EtT306Oh";
    private static final String smsUrl = "http://api.mix2.zthysms.com/v2/sendSms";

    public static void sendSms(String phone, String content) {
        Date date = new Date();
        long tKey = date.getTime() / 1000;
        String encryptPassword = Md5Utils.encrypt(Md5Utils.encrypt(password).toLowerCase() + tKey).toLowerCase();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", encryptPassword);
        map.put("tKey", String.valueOf(tKey));
        map.put("mobile", phone);
        map.put("content", content);
        JSONObject jsonObject = HttpClientUtils.invokePostWithMap(smsUrl, map);
        log.info("sendSms 短信返回结果："+jsonObject.toJSONString());
        if (jsonObject == null) {
            log.error("sendSms 短信发送失败");
            throw new WorkingException(RespEnum.CODE_SYSTEM_ERROR.getCode(), "sendSms 短信发送失败");
        }
        Integer respCode = jsonObject.getInteger("code");
        if (respCode != HttpStatus.OK.value()) {
            log.error("sendSms 短信发送失败");
            throw new WorkingException(RespEnum.CODE_SYSTEM_ERROR.getCode(), "sendSms 短信发送失败");
        }
    }
}
