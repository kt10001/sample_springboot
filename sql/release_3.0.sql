################### v3.0 sql ###################

-- 提现记录表 新增字段
alter table manager_income add bg_status tinyint(2) DEFAULT 0 comment '后台审批状态 0-待审核 1-已通过 2-未通过' after request_id;

-- 添加权限
update permission set url = '/zyk/admin/pay/list' where uuid='c8723f05-ca15-11ec-9b33-0242ac110010';
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('e0f06238-fb70-11ec-82b6-0242ac110002', 'c8723f05-ca15-11ec-9b33-0242ac110001', '提现审批', '/zyk/admin/pay/approve');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e0f06238-fb70-11ec-82b6-0242ac110002');

-- 添加表
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '文件名',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转链接',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `namex_uuid` (`name`) USING BTREE COMMENT 'name索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件信息';

--新增权限
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', NULL, '文件管理', NULL, 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('feb8a5ac-fa1c-e4d2-2abf-6fed0c2a8bdd', 'eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', '新增文件', '/zyk/admin/file/add', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('fd5a66f8-e624-0cb2-312a-1cb43d3f462c', 'eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', '编辑文件', '/zyk/admin/file/update', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('999843d1-a2c2-b4b0-37b8-5ccf258d1263', 'eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', '文件列表', '/zyk/admin/file/list', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('eddbe62a-db4b-6159-a56e-2a7bf63e3726', 'eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', '删除文件', '/zyk/admin/file/delete', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'eee2a68b-a5a9-4b4c-80f2-bb38bb2eff48', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'feb8a5ac-fa1c-e4d2-2abf-6fed0c2a8bdd', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'fd5a66f8-e624-0cb2-312a-1cb43d3f462c', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '999843d1-a2c2-b4b0-37b8-5ccf258d1263', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'eddbe62a-db4b-6159-a56e-2a7bf63e3726', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');

INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`, `comment`, `is_deleted`, `create_at`, `update_at`) VALUES ('rewardMoney', '399,199,99', 4, '奖励金额', 0, '2022-07-07 02:08:11', NULL);
INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`, `comment`, `is_deleted`, `create_at`, `update_at`) VALUES ('friendCount', '80,40,20', 4, '邀请好友人数', 0, '2022-07-07 02:08:11', NULL);
INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`, `comment`, `is_deleted`, `create_at`, `update_at`) VALUES ('friendEventDate', '2022-08-12 23:59:59', 0, '邀请好友活动截止时间', 0, '2022-07-07 02:13:07', NULL);

alter table manager_level add be_friend_count int DEFAULT '0' COMMENT '已达好友人数' after be_team_count;
alter table manager_level add is_invite tinyint(2) DEFAULT '0' COMMENT '是否被邀请 0未邀请 1已邀请' after is_send2;
alter table manager_level add friend_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '邀请时间' after is_invite;

alter table manager_entry add type tinyint(2) DEFAULT '0' COMMENT '0产品入账1活动入账' after amount;


CREATE TABLE `activity_log` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `friend_event_date` varchar(64) DEFAULT NULL COMMENT '活动时间',
  `activity_content` varchar(1024) DEFAULT NULL COMMENT '活动结果',
  `activity_rule` varchar(256) DEFAULT NULL COMMENT '活动规则',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='活动记录表';

-- 数据库变更
ALTER TABLE `qr_code`
	ADD COLUMN `is_loan` tinyint(2) NULL COMMENT '是不是贷款 0贷款 1信用卡' AFTER `context`;