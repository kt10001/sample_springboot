package com.shouxin.yy.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wubaochun
 */
public class WxPayConstant {
	/**
	 * 微信查询订单地址
	 */
	public static final String QUERY_ORDER = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s?mchid=1626709973";
	/**
	 * 微信下单地址
	 */
	public static final String PAY_ORDER = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";
	/**
	 * 微信退款地址
	 */
	public static final String REFUND = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
	/**
	 * 商户号
	 */
	public static final String MCH_ID = "1626709973";
	/**
	 * 商户证书序列号
	 */
	public static final String MCH_SERIAL_NO = "38D3B9365A1BF10809F0B7D26D2207C9EA66DD2C";
	/**
	 * api密钥
	 */
	public static final String API_V3KEY = "49a17fe056604fa098b3d5b94db76a51";
	/**
	 * appid
	 */
	public static final String APP_ID = "wxa0ceae841aca283a";
	/**
	 * 签名固定字符串
	 */
	public static final String PACKAGE = "Sign=WXPay";
	/**
	 * 商户私钥
	 */
	public static final String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
			"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCC/TSFiGQ2Gvb\n" +
			"Yx4XMfpprxqvPxcFXNA62AoW68opeGJ7NLIQi6Uo6bq9babgvPUwHA8RNcFvuyMC\n" +
			"WnAUpokeR1duFtVD8kv9PHGXkNGqO6gU4Cx0RNpOCmEW9wrzjz8hd/Ng6BYvbVgN\n" +
			"cLssdSdIMdhZTeDZ4VXGMyikCV9VKwpt1YBjUelGcxXZxzPzFGpJ1cW6wkiZIVYd\n" +
			"FCcT3SZha4XhPzSMX3n5pg8jXyk7MPeiIN8cXU8xAwDEIp8VmZLhxaWPnDI8AGT2\n" +
			"veUJgb/gzpIUcaNV0t6ONgakOTlnhHcguxp8OjeklKiiJx4sudinTZw2E38cQGbe\n" +
			"sLq5QNLRAgMBAAECggEAK+LUXedPdBjeW+HQ3mIZRmmp2VSlejsBhS1zKrftIu/t\n" +
			"JfxHAWLz2YrzBwCTq2RQ966A4d2MgB6Mzm1xx9naTRTJe0aCuTlFYmKXNjY0lRGk\n" +
			"9AO3ShyAWwIR70W0Hl2ZY5JjYtlamyNZtMB4NJfSaIuNaLUqU1yZL5hGasML4pDS\n" +
			"eC5wfun2V/fAhQnUEJ+3FxZBnC8EAjgVzVXYhXwiLVlcUdMV/8Dm4cfh9XLVc7Ci\n" +
			"UUv4ZYuVQ7zQgHCikY3OQUbmwmEr3rTz+OYjQAGZ4DO562nHUURvlM+kYY38GmlY\n" +
			"XdOCfzhYUE6lRiLHvkzIDhCSciMNLhPQc0NJ9ZsYAQKBgQDq8yqB7oH9Ygcye8HD\n" +
			"XjYQR9BMZ0tGameJmthapnvX8WTA2rYZzdorfRtmtOSJRSiP1MzyRAZnnx2LI1E1\n" +
			"epLuimPQTPocPozGh6d5pklBNgFRni3KS2fWK3sjRJKeB7h54o/t5bJiS4URlhf1\n" +
			"jqvphYH7bxsq7wBQ+S+PFnekkQKBgQDTbqGWJZi78oxIAzxPV9Wd+aN/S172jf6S\n" +
			"+D1JUAqkqp6peV4Z5pNJHtjeS8itUfxH2csAREmXaCHWQi827We2N05Zm54kxtMV\n" +
			"rgYCRR5qq4i3RWQ8nF4ZUyoYypcjMQARJ3D7AX8aHLtYpgR8pHhswE21hoVhdNdg\n" +
			"Nwf4vPxqQQKBgQCZeUJZIa20EKbW6VSHBDGYrPB6GDdpxfPgRU/y1zGqu7qu569w\n" +
			"Z7GOGukdTCjFKnH2knFWB+2PHrczvlw77NeyDqBo3v+6F3np7Y8Ovfq4KEjwQb1z\n" +
			"mZI4qqqDPTXxGOX+aGrQYe0GnIJOHJeGBi5yGo3v6oH6p6izPDM+6tQ4oQKBgCys\n" +
			"+8fWOee84Jd214+MZ77xuPJ04qQGbPxxJ8IN/7G7u7rjwlaGuiiBNCIEsWquIDiu\n" +
			"dI6h30r23e+AHKnmkDuYhB27HDd5K7ExDGP+ZubzR/gx2XRVNizzvblvVXBCMllt\n" +
			"lBn1vv2thIi+y8PqnOed2s24lwZ4wem6txyAEnYBAoGBALz8vk3LonnT3/2IPu5d\n" +
			"RmnUMiCcrqhn5bvgrUFVf8WaqzpG5yMAikm6bovRxtGLlnLozuylX3Y8766Nlgcf\n" +
			"FKsB+wBFQOVWKeY+dnLfEOPe6bTz7fa1G3/8JVcXzkVj2YQHR5FewX1lAmlWWc8R\n" +
			"BpyegJQr6E+wlH6SCLqQzkc5\n" +
			"-----END PRIVATE KEY-----\n";

	/**
	 * 证书密钥
	 */
	public static final String CERT_KEY = "-----BEGIN CERTIFICATE-----\n" +
			"MIID8DCCAtigAwIBAgIUONO5Nlob8QgJ8LfSbSIHyepm3SwwDQYJKoZIhvcNAQEL\n" +
			"BQAwXjELMAkGA1UEBhMCQ04xEzARBgNVBAoTClRlbnBheS5jb20xHTAbBgNVBAsT\n" +
			"FFRlbnBheS5jb20gQ0EgQ2VudGVyMRswGQYDVQQDExJUZW5wYXkuY29tIFJvb3Qg\n" +
			"Q0EwHhcNMjIwNjEwMDE0MjE3WhcNMjcwNjA5MDE0MjE3WjCBgTETMBEGA1UEAwwK\n" +
			"MTYyNjcwOTk3MzEbMBkGA1UECgwS5b6u5L+h5ZWG5oi357O757ufMS0wKwYDVQQL\n" +
			"DCTmna3lt57pppbmlrDnvZHnu5znp5HmioDmnInpmZDlhazlj7gxCzAJBgNVBAYM\n" +
			"AkNOMREwDwYDVQQHDAhTaGVuWmhlbjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCC\n" +
			"AQoCggEBAMIL9NIWIZDYa9tjHhcx+mmvGq8/FwVc0DrYChbryil4Yns0shCLpSjp\n" +
			"ur1tpuC89TAcDxE1wW+7IwJacBSmiR5HV24W1UPyS/08cZeQ0ao7qBTgLHRE2k4K\n" +
			"YRb3CvOPPyF382DoFi9tWA1wuyx1J0gx2FlN4NnhVcYzKKQJX1UrCm3VgGNR6UZz\n" +
			"FdnHM/MUaknVxbrCSJkhVh0UJxPdJmFrheE/NIxfefmmDyNfKTsw96Ig3xxdTzED\n" +
			"AMQinxWZkuHFpY+cMjwAZPa95QmBv+DOkhRxo1XS3o42BqQ5OWeEdyC7Gnw6N6SU\n" +
			"qKInHiy52KdNnDYTfxxAZt6wurlA0tECAwEAAaOBgTB/MAkGA1UdEwQCMAAwCwYD\n" +
			"VR0PBAQDAgTwMGUGA1UdHwReMFwwWqBYoFaGVGh0dHA6Ly9ldmNhLml0cnVzLmNv\n" +
			"bS5jbi9wdWJsaWMvaXRydXNjcmw/Q0E9MUJENDIyMEU1MERCQzA0QjA2QUQzOTc1\n" +
			"NDk4NDZDMDFDM0U4RUJEMjANBgkqhkiG9w0BAQsFAAOCAQEAONqQtEhrHHfJ5iGH\n" +
			"ZB9Tt/1yIYbwWLrGqJJivQM9/j5Tv5czsfiRJSMGdxyNaqvwfM0Ws1NdBVkatkSg\n" +
			"r6ImFTf9ufvwhyDM2HOmFEZzqItQAGna8MfOvJHYkuniWue32oO+ttxUwb1YZjDH\n" +
			"faiQH39YWZrppT1+ziMrfIytqMBr2I3jWVjLuank7NYqHudX8IJ1HAxB5RMdSxkD\n" +
			"OEajnp2OnRQLAQ06hNWJ1HkqO9lAEx2Gw+/Sr+Gbs6c0ePvSeSHbUikt0Y2jl11c\n" +
			"bZUzR2EpXE7CIc1XsCO+v3O51ONZHf0+zrW0onap+uDV3EpBwVgrwadLbIZUOd9+\n" +
			"g9L5pQ==\n" +
			"-----END CERTIFICATE-----";
	/**
	 * 人民币
	 */
	public static final String CURRENCY = "CNY";
	/**
	 * 场景类型
	 */
	public static final String TYPE = "Wap";

	public static final String TEXT = "wxa0ceae841aca283a\n" +
			"%s\n" +
			"%s\n" +
			"prepay_id=%s\n";

	public static final Map<Integer, String> PRODUCT_TYPE = new HashMap() {{
		put(0, "税票查询");
		put(1, "会员开通");
	}};

}
