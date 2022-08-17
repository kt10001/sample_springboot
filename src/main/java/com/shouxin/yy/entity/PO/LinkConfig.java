package com.shouxin.yy.entity.PO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xingxing
 * @date 2022/06/09
 */
@Component
public class LinkConfig {

    /** 进件进度查询地址 */
    public static String INCOMING;

    /** 会员页面地址 */
    public static String VIP;

    /** 贷款产品详情页面地址 */
    public static String PRODUCT_DETAIL;


    @Value("${link.incoming}")
    public void setIncoming(String incoming) {
        INCOMING = incoming;
    }

    @Value("${link.vip}")
    public void setVip(String vip) {
        VIP = vip;
    }

    @Value("${link.productDetail}")
    public void setProductDetail(String productDetail) {
        PRODUCT_DETAIL = productDetail;
    }

}
