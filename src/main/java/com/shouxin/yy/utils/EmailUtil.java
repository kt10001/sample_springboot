package com.shouxin.yy.utils;

import lombok.extern.slf4j.Slf4j;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;


/**
 * @author wubaochun
 */
@Slf4j
public class EmailUtil {

    static Session session = null;

    public static synchronized Session getSession() {
        if (session != null) {
            return session;
        }
        // 服务器地址:
        String smtp = "smtp.mxhichina.com";
        // 登录用户名:
        String username = "booleandatamsg@shouxin168.com";
        // 登录口令:
        String password = "Qwe123456_";
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        // SMTP主机名
        props.put("mail.smtp.host", smtp);
        // 主机端口号
        props.put("mail.smtp.port", "587");
        // 是否需要用户认证
        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public static void sendEmail(String email, String title, String content) {
        session = getSession();

        MimeMessage message = new MimeMessage(session);
        Multipart multipart = new MimeMultipart();
        // 设置发送方地址:
        try {
            message.setFrom(new InternetAddress("booleandatamsg@shouxin168.com"));

        // 设置接收方地址:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        // 设置邮件主题:
        message.setSubject(title, "UTF-8");
        // 设置邮件正文:
        message.setText(content, "UTF-8", "html");
        // 发送:
        Transport.send(message);
        log.info("[send_email_code] email_code send success");

        } catch (MessagingException e) {
            log.error("[send_email_error] email send error");
        }
    }

    public static void sendEmailFile(String email, String title, String content, String filename){
        session = getSession();

        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址:
        try {
        message.setFrom(new InternetAddress("booleandatamsg@shouxin168.com"));
        // 设置接收方地址:
        InternetAddress[] sendTo = InternetAddress.parse(email);
        message.setRecipients(MimeMessage.RecipientType.TO, sendTo);
        // 设置邮件主题:
        message.setSubject(title, "UTF-8");
        // 设置邮件正文:
        message.setText(content, "UTF-8", "html");
        // 设置附件
        MimeBodyPart fileBody = new MimeBodyPart();
        fileBody.setText(content, "UTF-8", "html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(fileBody);

        fileBody = new MimeBodyPart();
        File file = new File(filename);
        DataSource source = new FileDataSource(file);
        fileBody.setDataHandler(new DataHandler(source));
        fileBody.setFileName(file.getName());
        multipart.addBodyPart(fileBody);

        message.setContent(multipart);
        // 发送:
        Transport.send(message);
        log.info("[send_email_code] email_code send success");
        } catch (MessagingException e) {
            log.error("[send_email_error] email send error");
        }
    }

    public static void main(String[] args) throws MessagingException {
    }
}
