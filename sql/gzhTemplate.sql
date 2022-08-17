-- 添加公众号模板表
CREATE TABLE `notice_template` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模板标题',
  `template_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模板id',
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模板类型',
  `first` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消息头',
  `context` text COLLATE utf8mb4_general_ci COMMENT '内容',
  `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消息尾',
  `url` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '跳转链接',
  `status` tinyint DEFAULT NULL COMMENT '状态 0禁用 1启用',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公众号模板表';

ALTER TABLE notice_template ADD unique(`title`);


insert into `config_property`(`config_key`,`config_value`,`config_type`,`comment`,`is_deleted`,`create_at`,`update_at`) values
('msgTemplate','[
{
"title": "注册成功提醒",
"templateId": "O5wiOSMAMAM_ybxq89nUokwdZYDcVVowrgvdC1kJ6uI",
"detail": "{{first.DATA}}\\n手机号码：{{keyword1.DATA}}\\n注册时间：{{keyword2.DATA}}\\n{{remark.DATA}}"
},
{
"title": "提现申请提醒",
"templateId": "Ob6ANosUevay4-RKGlfVVnwzyBLe8tLEfwF6TsQs5eI",
"detail": "{{first.DATA}}\\n银行卡号：{{keyword1.DATA}}\\n提现金额：{{keyword2.DATA}}\\n提现时间：{{keyword3.DATA}}\\n{{remark.DATA}}"
},
{
"title": "会员提醒",
"templateId": "p8IBSn0kwntO1BK0vWWgqiC4CpKaztIVbLuILc4BCJE",
"detail": "{{first.DATA}}\\n当前级别：{{keyword1.DATA}}\\n变更时间：{{keyword2.DATA}}\\n{{remark.DATA}}"
},
{
"title": "经理等级提升提醒",
"templateId": "lEb1ZCNd4MA37roEFy1ySdcGw_E-Gcb8YGxo7mht-rg",
"detail": "{{first.DATA}}\\n原先等级：{{keyword1.DATA}}\\n当前等级：{{keyword2.DATA}}\\n{{remark.DATA}}"
}
]',2,'消息模板',0,'2022-07-25 09:59:13','2022-07-27 14:58:16');
SET FOREIGN_KEY_CHECKS = 1;



-- 添加权限
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('1b24c5a9-9e40-482a-a30d-35ec087e73fb', NULL, '消息模板管理', NULL, 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('5b24c5a9-9284-4291-f242-42ffb1e57f3c', '1b24c5a9-9e40-482a-a30d-35ec087e73fb', '查看公众号模板', '/zyk/admin/notice/noticeConfig', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('559a4057-2f86-4291-ad3a-1a979439d364', '1b24c5a9-9e40-482a-a30d-35ec087e73fb', '查看公众号模板详情', '/zyk/admin/notice/detail', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('b54b521d-bacd-4f8c-9582-7f9a2c83dccd', '1b24c5a9-9e40-482a-a30d-35ec087e73fb', '新增公众号模板', '/zyk/admin/notice/add', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ed9cd7e6-f242-4cad-b5fe-93769796e515', '1b24c5a9-9e40-482a-a30d-35ec087e73fb', '编辑公众号模板', '/zyk/admin/notice/update', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');


INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '1b24c5a9-9e40-482a-a30d-35ec087e73fb', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '5b24c5a9-9284-4291-f242-42ffb1e57f3c', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '559a4057-2f86-4291-ad3a-1a979439d364', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'b54b521d-bacd-4f8c-9582-7f9a2c83dccd', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ed9cd7e6-f242-4cad-b5fe-93769796e515', 0, '2022-07-21 11:44:19', '2022-07-21 11:44:19');
