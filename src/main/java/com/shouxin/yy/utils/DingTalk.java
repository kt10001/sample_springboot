package com.shouxin.yy.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @time 2021/6/7 6:51 下午
 * @Author feikong
 */
@Slf4j
public class DingTalk {

    /**
     * 通用消息接口
     * 调用前构建markdown消息内容
     * @param webhook 机器人webhook
     */
    public static void sendMarkdown(String title, String text, String webhook) {
        log.info("钉钉markdown消息发送 title: {}, webhook: {}", title, webhook);

        DingTalkClient client = new DefaultDingTalkClient(webhook);
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(title);
        markdown.setText(text);
        request.setMarkdown(markdown);
        try {
            client.execute(request);
        } catch (Exception e) {
            log.error("钉钉 消息发送失败：{}", e.getMessage());
        }
    }

    public static void productNotice(String name, String link, String webhook, String url) {
        DingTalkClient client = new DefaultDingTalkClient(webhook);
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("产品管理通知");
        String text = String.format("#### 产品上架提醒\n\n " +
                        "> 产品名称：%s\n\n " +
                        "> 产品链接：%s\n\n " +
                        "> ###### 点击登陆 [99资源客管理后台](%s) 进行查看 \n",
                name, link, url);
        markdown.setText(text);
        request.setMarkdown(markdown);
        try {
            client.execute(request);
        } catch (Exception e) {
            log.error("钉钉 产品上架通知 消息发送失败：{}", e.getMessage());
        }
    }

    /**
     * 发起提现通知
     * @param name
     * @param requestId
     * @param amount
     */
    public static void payNotice(String name, String requestId, BigDecimal amount, String webhook, String url) {
        DingTalkClient client = new DefaultDingTalkClient(webhook);
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("提现通知");
        String text = String.format("#### 提现提醒\n\n " +
                        "> 提现用户：%s\n\n " +
                        "> 单号：%s\n\n " +
                        "> 金额：%s\n\n " +
                        "> ###### 点击登陆 [99资源客管理后台](%s) 进行查看 \n",
                name, requestId, amount, url);
        markdown.setText(text);
        request.setMarkdown(markdown);
        try {
            client.execute(request);
        } catch (Exception e) {
            log.error("钉钉 提现通知 消息发送失败：{}", e.getMessage());
        }
    }

}
