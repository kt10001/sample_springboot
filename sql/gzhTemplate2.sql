CREATE TABLE `manager_status` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户经理uuid',
  `integral_status` tinyint DEFAULT '0' COMMENT '积分状态（0未冻结1已冻结）',
  `sign_status` tinyint DEFAULT '0' COMMENT '是否签到提醒 0-否 1-是',
  `is_follow` tinyint DEFAULT '1' COMMENT '是否关注公众号0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户经理状态表';

-- 客户经理积分状态更新
delimiter $$
DROP PROCEDURE IF EXISTS update_ms;
create PROCEDURE update_ms ()
begin
-- 声明自定义变量
DECLARE iuuid VARCHAR(64);
-- 声明游标结束变量
DECLARE done INT DEFAULT 0;
-- 声明游标 cr 以及游标读取到结果集最后的处理方式
DECLARE cur CURSOR FOR SELECT uuid FROM manager;
DECLARE continue handler for not found set done = 1;
-- 打开游标
OPEN cur;
-- 循环
  ms_loop: LOOP

     -- 获取游标中值并赋值给变量
     FETCH cur INTO iuuid;
     -- 判断游标是否到底，若到底则退出游标
     -- 需要注意这个判断
     IF done=1 THEN
         LEAVE ms_loop;
     END IF;
     -- 需要执行的语句
     INSERT INTO manager_status (manager_uuid) VALUE (iuuid);
  END LOOP ms_loop;
-- 关闭游标
CLOSE cur;
end$$
-- 最后重新定义为;
delimiter ;

-- 执行存储过程
call update_ms;

update config_property set config_value = '[
{
"title": "注册成功通知",
"templateId": "O5wiOSMAMAM_ybxq89nUokwdZYDcVVowrgvdC1kJ6uI",
"detail": "{{first.DATA}}\n手机号码：{{keyword1.DATA}}\n注册时间：{{keyword2.DATA}}\n{{remark.DATA}}"
},
{
"title": "等级升级通知",
"templateId": "KN_bd0Yrbd-EKkp8oJhOho5LUYrNXuGswrTQJ_jnPoc",
"detail": "{{first.DATA}}\n用户昵称：{{keyword1.DATA}}\n最新等级：{{keyword2.DATA}}\n生效时间：{{keyword3.DATA}}\n{{remark.DATA}}"
},
{
"title": "提现申请通知",
"templateId": "Ob6ANosUevay4-RKGlfVVnwzyBLe8tLEfwF6TsQs5eI",
"detail": "{{first.DATA}}\n银行卡号：{{keyword1.DATA}}\n提现金额：{{keyword2.DATA}}\n提现时间：{{keyword3.DATA}}\n{{remark.DATA}}"
},
{
"title": "提现到账通知",
"templateId": "iAJ6vnSFeSjhPRyc-yGtxMbpPXkUkuWG4j8oCpuEYio",
"detail": "{{first.DATA}}\n提现金额：{{keyword1.DATA}}\n提现账户：{{keyword2.DATA}}\n提现时间：{{keyword3.DATA}}\n到账时间：{{keyword4.DATA}}\n{{remark.DATA}}"
},
{
"title": "业务办理进度通知",
"templateId": "KxPYHoSl25va4r1FKr7c4KXmkrtb4QBKIVo8Qhb6PrE",
"detail": "{{first.DATA}}\n客户名称：{{keyword1.DATA}}\n办理进度：{{keyword2.DATA}}\n办理时间：{{keyword3.DATA}}\n经办人：{{keyword4.DATA}}\n{{remark.DATA}}"
},
{
"title": "办理成功提醒",
"templateId": "Vg5bFUVRsfOTPkZdGOPUCVn5wsZJ2gH4lFYbjnd_Uok",
"detail": "{{first.DATA}}\n业务类型：{{keyword1.DATA}}\n处理时间：{{keyword2.DATA}}\n{{remark.DATA}}"
},
{
"title": "会员等级变更通知",
"templateId": "lEb1ZCNd4MA37roEFy1ySdcGw_E-Gcb8YGxo7mht-rg",
"detail": "{{first.DATA}}\n原先等级：{{keyword1.DATA}}\n当前等级：{{keyword2.DATA}}\n{{remark.DATA}}"
},
{
"title": "会员续费成功提醒",
"templateId": "p8IBSn0kwntO1BK0vWWgqiC4CpKaztIVbLuILc4BCJE",
"detail": "{{first.DATA}}\n当前级别：{{keyword1.DATA}}\n变更时间：{{keyword2.DATA}}\n{{remark.DATA}}"
}
]' where config_key='msgTemplate';

-- 变更消息模板
update `notice_template` set `title`='注册成功提醒',`template_id`='O5wiOSMAMAM_ybxq89nUokwdZYDcVVowrgvdC1kJ6uI',`type`='注册提醒',`first`='{\"value\":\"恭喜您成功加入99资源客~\",\"color\":\"#173177\"}',`context`='{\"手机号码\":{\"value\":\"*****\",\"color\":\"#173177\"},\"注册时间\":{\"value\":\"*****\",\"color\":\"#173177\"}}',`remark`='{\"value\":\"接下来，让我们一起推广赚钱吧\",\"color\":\"#173177\"}' where `id`=1;
update `notice_template` set `title`='提现申请提醒',`template_id`='Ob6ANosUevay4-RKGlfVVnwzyBLe8tLEfwF6TsQs5eI',`type`='提现提醒',`first`='{\"value\":\"您好，您在我平台提现申请已提交。\",\"color\":\"#ef1818\"}',`context`='{\"银行卡号\":{\"value\":\"n1\",\"color\":\"#0882f3\"},\"提现金额\":{\"value\":\"n2\",\"color\":\"#13ef15\"},\"提现时间\":{\"value\":\"n3\",\"color\":\"#9ff316\"}}',`remark`='{\"value\":\"请留意余额变化\",\"color\":\"#000000\"}' where `id`=2;
update `notice_template` set `title`='会员开通成功提醒',`template_id`='lEb1ZCNd4MA37roEFy1ySdcGw_E-Gcb8YGxo7mht-rg',`type`='会员提醒',`first`='{\"value\":\"恭喜升级\",\"color\":\"#e31a1a\"}',`context`='{\"当前级别\":{\"value\":\"n1\",\"color\":\"#0fe953\"},\"变更时间\":{\"value\":\"n2\",\"color\":\"#2213ca\"}}',`remark`='{\"value\":\"正常\",\"color\":\"#dd0fb0\"}' where `id`=3;
update `notice_template` set `title`='会员续费成功提醒',`template_id`='p8IBSn0kwntO1BK0vWWgqiC4CpKaztIVbLuILc4BCJE',`type`='会员提醒',`first`='{\"value\":\"恭喜升级\",\"color\":\"#e31a1a\"}',`context`='{\"当前级别\":{\"value\":\"n1\",\"color\":\"#0fe953\"},\"变更时间\":{\"value\":\"n2\",\"color\":\"#2213ca\"}}',`remark`='{\"value\":\"正常\",\"color\":\"#dd0fb0\"}' where `id`=4;
update `notice_template` set `title`='提升高级经理提醒',`template_id`='KN_bd0Yrbd-EKkp8oJhOho5LUYrNXuGswrTQJ_jnPoc',`type`='升级提醒',`first`='{\"value\":\"恭喜您成为高级经理，享出师奖励！\",\"color\":\"#0bf414\"}',`context`='{\"用户昵称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"最新等级\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"生效时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}',`remark`='{\"value\":\"查看您的权益详情\",\"color\":\"#13f10e\"}' where `id`=5;
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (6, '提升高级总监提醒', 'KN_bd0Yrbd-EKkp8oJhOho5LUYrNXuGswrTQJ_jnPoc', '升级提醒', '{\"value\":\"恭喜您成为高级总监，享出师奖和越级奖！\",\"color\":\"#0bf414\"}', '{\"用户昵称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"最新等级\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"生效时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}', '{\"value\":\"查看您的权益详情\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:32:05', '2022-08-16 01:56:28');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (7, '进件成功提醒', 'KxPYHoSl25va4r1FKr7c4KXmkrtb4QBKIVo8Qhb6PrE', '业务进度提醒', '{\"value\":\"恭喜您进件成功\",\"color\":\"#0bf414\"}', '{\"客户名称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"办理进度\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"办理时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"经办人\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}', '{\"value\":\"点击查看详情，更多问题可咨询客服\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:34:20', '2022-08-16 01:56:28');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (8, '授信通过提醒', 'KxPYHoSl25va4r1FKr7c4KXmkrtb4QBKIVo8Qhb6PrE', '业务进度提醒', '{\"value\":\"您有客户授信已通过\",\"color\":\"#0bf414\"}', '{\"客户名称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"办理进度\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"办理时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"经办人\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}', '{\"value\":\"点击查看详情，更多问题可咨询客服\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:37:33', '2022-08-16 01:56:29');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (9, '审批未通过提醒', 'KxPYHoSl25va4r1FKr7c4KXmkrtb4QBKIVo8Qhb6PrE', '业务进度提醒', '{\"value\":\"您有客户授信未通过\",\"color\":\"#0bf414\"}', '{\"客户名称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"办理进度\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"办理时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"经办人\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}', '{\"value\":\"点击查看详情，更多问题可咨询客服\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:39:06', '2022-08-16 01:56:30');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (10, '结算提醒', 'KxPYHoSl25va4r1FKr7c4KXmkrtb4QBKIVo8Qhb6PrE', '业务进度提醒', '{\"value\":\"您有客户已提款\",\"color\":\"#0bf414\"}', '{\"客户名称\":{\"value\":\"n1\",\"color\":\"#2710e0\"},\"办理进度\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"办理时间\":{\"value\":\"n2\",\"color\":\"#d011d3\"},\"经办人\":{\"value\":\"n2\",\"color\":\"#d011d3\"}}', '{\"value\":\"点击查看详情，更多问题可咨询客服\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:40:03', '2022-08-16 02:17:10');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (11, '现金红包办理成功提醒', 'Vg5bFUVRsfOTPkZdGOPUCVn5wsZJ2gH4lFYbjnd_Uok', '办理成功提醒', '{\"value\":\"恭喜您获得现金红包奖励!\",\"color\":\"#0bf414\"}', '{\"业务类型\":{\"value\":\"*****\",\"color\":\"#173177\"},\"处理时间\":{\"value\":\"*****\",\"color\":\"#173177\"}}', '{\"value\":\"备注：点击查看现金红包详情\"，\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:42:16', '2022-08-16 01:56:32');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (12, '进件红包办理成功提醒', 'Vg5bFUVRsfOTPkZdGOPUCVn5wsZJ2gH4lFYbjnd_Uok', '办理成功提醒', '{\"value\":\"恭喜您获得进件现金券\",\"color\":\"#0bf414\"}', '{\"业务类型\":{\"value\":\"*****\",\"color\":\"#173177\"},\"处理时间\":{\"value\":\"*****\",\"color\":\"#173177\"}}', '{\"value\":\"备注：点击查看现金券详情\"，\",\"color\":\"#13f10e\"}', NULL, 1, '2022-08-15 08:43:55', '2022-08-16 01:56:32');
INSERT INTO `notice_template` (`id`, `title`, `template_id`, `type`, `first`, `context`, `remark`, `url`, `status`, `create_at`, `update_at`) VALUES (13, '提现到账通知', 'iAJ6vnSFeSjhPRyc-yGtxMbpPXkUkuWG4j8oCpuEYio', '提现提醒', '{\"value\":\"您好，您在我平台提现已到账。\",\"color\":\"#ef1818\"}', '{\"提现金额\":{\"value\":\"n1\",\"color\":\"#0882f3\"},\"提现账户\":{\"value\":\"n2\",\"color\":\"#13ef15\"},\"提现时间\":{\"value\":\"n3\",\"color\":\"#9ff316\"},\"到账时间\":{\"value\":\"n3\",\"color\":\"#9ff316\"}}', '{\"value\":\"备注：点击查看收入明细\",\"color\":\"#000000\"}', NULL, 1, '2022-08-15 08:46:13', '2022-08-16 01:56:34');
