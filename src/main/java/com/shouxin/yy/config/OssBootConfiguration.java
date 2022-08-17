//package com.shouxin.yy.config;
//
//import com.shouxin.yy.utils.OssBootUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OssBootConfiguration {
//
//    @Value("${oss.endpoint}")
//    private String endpoint;
//    @Value("${oss.accessKey}")
//    private String accessKeyId;
//    @Value("${oss.secretKey}")
//    private String accessKeySecret;
//    @Value("${oss.bucketName}")
//    private String bucketName;
//    @Value("${oss.staticDomain}")
//    private String staticDomain;
//
//
//    @Bean
//    public void initOssBootConfiguration() {
//        OssBootUtil.setEndPoint(endpoint);
//        OssBootUtil.setAccessKeyId(accessKeyId);
//        OssBootUtil.setAccessKeySecret(accessKeySecret);
//        OssBootUtil.setBucketName(bucketName);
//        OssBootUtil.setStaticDomain(staticDomain);
//    }
//}