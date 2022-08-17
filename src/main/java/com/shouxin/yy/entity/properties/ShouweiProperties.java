package com.shouxin.yy.entity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @time 2022/4/26 5:51 下午
 * @Author feikong
 */
@Data
@ConfigurationProperties(prefix = "shouwei")
@Component
public class ShouweiProperties {

    private String companyUuid;
    
    private String aesKey;

    private String url;
}
