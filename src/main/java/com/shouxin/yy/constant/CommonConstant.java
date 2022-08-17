package com.shouxin.yy.constant;

/**
 * 常量
 *
 * @author MrBird
 */
public interface CommonConstant {

    /**
     * 查询银行卡所属机构code
     */
    String QUERY_BANK_URL = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json";

    /**
     * 获取银行卡logo
     */
    String GET_BANK_LOGO_URL = "https://apimg.alipay.com/combo.png?d=cashier&t=";

    /**
     * 产品状态 0-下架 1-上架
     */
    Integer PRODUCT_USER_STATUS = 1;
    Integer PRODUCT_NOT_USER_STATUS = 0;

    /**
     * 登录用户Token令牌缓存KEY前缀
     */
    String PREFIX_USER_TOKEN  = "user_token_";

    /**
     * AES加密密钥
     */
    String AES_KEY = "pVPh2zN9kXjCisQ3";

    /**
     * token key
     */
    String TOKEN_KEY = "token";

    /**
     * 注册用户角色ID
     */
    Long REGISTER_ROLE_ID = 2L;

    /**
     * 排序规则：降序
     */
    String ORDER_DESC = "desc";

    /**
     * 排序规则：升序
     */
    String ORDER_ASC = "asc";

    /**
     * 前端页面路径前缀
     */
    String VIEW_PREFIX = "febs/views/";

    /**
     * 允许下载的文件类型，根据需求自己添加（小写）
     */
    String[] VALID_FILE_TYPE = {"xlsx", "zip"};

    /**
     * febs-shiro线程池名称
     */
    String FEBS_SHIRO_THREAD_POOL = "febsShiroThreadPool";

    /**
     * febs-shiro线程名称前缀
     */
    String FEBS_SHIRO_THREAD_NAME_PREFIX = "febs-shiro-thread-";

    /**
     * 开发环境
     */
    String DEVELOP = "dev";

    /**
     * Windows 操作系统
     */
    String SYSTEM_WINDOWS = "windows";

    String REQUEST_ALL = "/**";

    String DAY_START_PATTERN_SUFFIX = " 00:00:00";
    String DAY_END_PATTERN_SUFFIX = " 23:59:59";

    /**
     * 验证码ey前缀
     */
    String VALIDATE_CODE_PREFIX = "99ke_captcha_";

    /**
     * 验证码有效期Key前缀
     */
    String VALIDATE_CODE_TIME_PREFIX = "febs_captcha_time_";

    /**
     * 限制次数
     */
    Integer LIMIT_10 = 10;

    /**
     * 超级管理员uuid
     */
    String SUPER_ADMIN_UUID = "1c7be48d-ca1d-11ec-9b33-0242ac110002";

    /**
     * 邮件配置
     */
    String EMAIL_TITLE = "99资源客";

    String BG_EMAIL_MODEL = "bg_email_model";

    String EVENT_DATE = "eventDate";

    String FRIEND_EVENT_DATE = "friendEventDate";

    String REWARD_MONEY = "rewardMoney";

    String FRIEND_COUNT = "friendCount";
}
